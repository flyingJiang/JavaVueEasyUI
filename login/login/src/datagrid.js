// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import iView from 'iview'
import 'iview/dist/styles/iview.css'

import axios from 'axios'
//easyui
import 'vx-easyui/dist/themes/default/easyui.css';
import 'vx-easyui/dist/themes/icon.css';
import 'vx-easyui/dist/themes/vue.css';
import EasyUI from 'vx-easyui';
import One from "./One";

Vue.use(EasyUI);

Vue.prototype.$axios = axios

Vue.use(iView)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#datagrid',
  render: h => h(DataGrid)
})

const _T = 100;
var mixin = {
  data() {
    return {cellFocused: false}
  }, methods: {
    beginEditingRow(gr, item, fend) {
      var col = item.column;
      if (col && col.editable == false) {
        gr.endEdit();
        return;
      }
      this.editing = true;
      var vm = this;
      var elem;
      if (item.element) {
        elem = $(item.element);
      } else {
        var rindex = gr.getRowIndex(item.row);
        elem = $($(gr.$el).find('tr.datagrid-row')[rindex]);
      }
      setTimeout(function () {
        elem.find('.datagrid-editable input').on('blur', function () {
          vm.cellFocused = false;
          setTimeout(function () {
            if (!vm.cellFocused) if (fend == undefined || fend() == true) {
              vm.validateRow(item.row, function () {
                gr.endEdit();
              });
            }
          }, _T);
        }).focus(function () {
          vm.cellFocused = true;
        });
      }, _T);
    }, appendNewRow(gr, obj, editing) {
      var list = gr.data;
      list.push(obj);
      if (editing) {
        setTimeout(function () {
          gr.beginEdit(gr.rows[list.length - 1]);
        }, 200);
      }
    }, deleteSelectedRows(gr) {
      if (this.hasSelectedRows(gr)) {
        this.$confirm('是否删除选中行?').then(() => {
          var list = gr.data;
          for (var i = list.length - 1; i >= 0; --i) {
            if (list[i].selected) {
              list.splice(i, 1);
            }
          }
        }).catch(() => {
        });
      }
    }, hasSelectedRows(gr) {
      var list = gr.data;
      for (var i = 0; i < list.length; ++i) {
        if (list[i].selected) {
          return true
        }
      }
    }
  }
}
export default mixin
