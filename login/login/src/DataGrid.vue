<template>
  <div>
    <div style="width:100%;text-align:right;background:#666;">
      <yh-button class="yh-icon" @click="onDeleteClick">删除</yh-button>
      <yh-button class="yh-icon" @click="onAddClick">添加</yh-button>
    </div>
    <DataGrid :data="data" :dblclickToEdit="true" editMode="row" style="width:100%;height:100%" @editBegin="onEditBegin"
              ref="datagrid">
      <GridColumn title width="50" align="center" :editabe="false">
        <template slot="body" slot-scope="scope">
          <CheckBox v-model="scope.row.selected"></CheckBox>
        </template>
      </GridColumn>
      <slot></slot>
    </DataGrid>
  </div>
</template>
<script>import yhbutton from "./Button";
import datagrid from "../../assets/mixins/datagrid";
import AsyncValidator from "async-validator";

function _validate(model, rules, fok, ffailed) {
  var validator = new AsyncValidator(rules);
  validator.validate(model, (errors, fields) => {
    if (errors) {
      ffailed(errors);
    } else {
      fok();
    }
  });
}

export default {
  name: "YhDataGrid", mixins: [datagrid], data() {
    return {data: [], editing: false};
  }, props: ["rows", "rules"], methods: {
    onEditBegin(item) {
      this.beginEditingRow(this.$refs.datagrid, item);
    }, onEditEnd() {
      this.editing = false;
    }, onAddClick() {
      this.$emit("append-row", this);
    }, appendRow(obj, editing) {
      this.appendNewRow(this.$refs.datagrid, obj, editing);
    }, onDeleteClick() {
      this.deleteSelectedRows(this.$refs.datagrid);
    }, validateRow(row, fok) {
      var vm = this;
      if (this.rules) {
        _validate(row, this.rules, fok, function (errors) {
          if (errors && errors.length > 0) {
            var msg = errors[0].message;
            vm.$alert(msg);
          }
        });
      } else {
        fok();
      }
    }, getRules(field) {
      if (this.rules) {
        return this.rules[field];
      }
    }, getFieldTitle(field) {
      var cols = this.$refs.datagrid.allColumns;
      for (var i = 0; i < cols.length; ++i) {
        var c = cols[i];
        if (c.field == field) {
          return c.title;
        }
      }
    }, onCancelClick() {
      this.$refs.datagrid.endEdit();
    }
  }, created() {
    if (this.rows) {
      this.data = this.rows;
    }
  }, components: {"yh-button": yhbutton}
};</script>
