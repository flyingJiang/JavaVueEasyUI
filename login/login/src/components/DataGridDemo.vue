<template>
  <div class="yh-page"><h2>DataGrid 演示</h2>
    <div class="desc"> Demo源代码： <code>/examples/components/modules/DataGridDemo.vue</code></div>
    <div class="yh-block" style="height:450px;">
      <yh-datagrid :rows="data" :rules="rules" @append-row="onAppendRow" style="width:90%;height:350px">
        <GridColumn field="itemid" title="Item ID"></GridColumn>
        <GridColumn field="name" title="名称" :editable="true"></GridColumn>
        <GridColumn field="listprice" title="价格" align="right" :editable="true" :sortable="true">
          <template slot="edit" slot-scope="scope">
            <NumberBox v-model="scope.row.listprice" :precision="1"></NumberBox>
          </template>
        </GridColumn>
        <GridColumn field="unitcost" title="单价" align="right" :editable="true" :sortable="true">
          <template slot="edit" slot-scope="scope">
            <NumberBox v-model="scope.row.unitcost"></NumberBox>
          </template>
        </GridColumn>
        <GridColumn field="date" title="日期" width="200" align="right" :editable="true">
          <template slot="body" slot-scope="scope">{{format_date(scope.row.date)}}</template>
          <template slot="edit" slot-scope="scope">
            <DateBox v-model="scope.row.date" format="yyyy-MM-dd" currentText="今天" closeText="关闭"></DateBox>
          </template>
        </GridColumn>
        <GridColumn field="attr" title="属性" width="20%" :editable="true"></GridColumn>
      </yh-datagrid>
    </div>
    <div class="yh-desc yh-block"><h2>引入 EasyUI</h2>
      <div style="height:30px;"><code>npm install vx-easyui --save</code></div>
      <div style="height:100px;">
        <pre>import 'vx-easyui/dist/themes/default/easyui.css'import 'vx-easyui/dist/themes/icon.css';import 'vx-easyui/dist/themes/vue.css';import EasyUI from 'vx-easyui';Vue.use(EasyUI);</pre>
      </div>
      <h3>Data</h3>
      <ul>
        <li>rows：数据</li>
      </ul>
      <h3>Events</h3>
      <ul>
        <li>append-row：新增行</li>
      </ul>
    </div>
  </div>
</template>
<script>import datagrid from '../comcompont/DataGrid'

export default {
  name: "DataGridDemo", data() {
    return {data: [], rules: {name: [{required: true, message: "请输入名称"}]}};
  }, methods: {
    onAppendRow(dg) {
      dg.appendRow({code: "", name: "", unitcost: 0, listprice: 0, attr: "", itemid: ""}, true);
    }, format_date(date) {
      var d = date.getDate();
      var m = date.getMonth() + 1;
      var y = date.getFullYear();
      return ("" + y + "-" + (m <= 9 ? "0" + m : m) + "-" + (d <= 9 ? "0" + d : d));
    }
  }, created() {
    this.data = [{
      code: "FI-SW-01",
      name: "Koi",
      unitcost: 10.0,
      listprice: 36.5,
      attr: "Large",
      date: new Date(),
      itemid: "EST-1"
    }, {
      code: "K9-DL-01",
      name: "Dalmation",
      unitcost: 12.0,
      listprice: 18.5,
      attr: "Spotted Adult Female",
      date: new Date(),
      itemid: "EST-2"
    }, {
      code: "RP-SN-01",
      name: "Rattlesnake",
      unitcost: 12.0,
      listprice: 38.5,
      attr: "Venomless",
      date: new Date(),
      itemid: "EST-3"
    }, {
      code: "RP-SN-01",
      name: "Rattlesnake",
      unitcost: 12.0,
      listprice: 26.5,
      attr: "Rattleless",
      date: new Date(),
      itemid: "EST-4"
    }, {
      code: "RP-LI-02",
      name: "Iguana",
      unitcost: 12.0,
      listprice: 35.5,
      attr: "Green Adult",
      date: new Date(),
      itemid: "EST-5"
    }, {
      code: "FL-DSH-01",
      name: "Manx",
      unitcost: 12.0,
      listprice: 158.5,
      attr: "Tailless",
      date: new Date(),
      itemid: "EST-6"
    }];
  }, components: {"yh-datagrid": datagrid,}
};</script>
<style></style>
