<template>
  <Layout style="width:100%;height:100%;">
    <LayoutPanel region="north" style="height:50px;">
      <!--      <div class="title">North Region</div>-->
      <div>
        <Label for="c_bank" align="left">银行名称:</Label>
        <ComboBox inputId="c_bank"
                  :data="bankData"
                  v-model="bankValue"
                  :editable="false"
                  :panelStyle="{height:'auto'}">
        </ComboBox>
<!--        <p v-if="value">选择值: {{value}}</p>-->

        <Label for="c_status" align="left">状态:</Label>
        <ComboBox inputId="c_status"
                  :data="statusData"
                  v-model="statusValue"
                  :editable="false"
                  :panelStyle="{height:'auto'}">
        </ComboBox>
        <!--        <p v-if="value">选择值: {{value}}</p>-->

        <LinkButton iconCls="icon-search">Search</LinkButton>
      </div>

    </LayoutPanel>
    <LayoutPanel region="south" style="height:50px;">
      <div class="title">South Region</div>
    </LayoutPanel>
    <!--    <LayoutPanel region="west" style="width:200px;">-->
    <!--      <div class="title">-->

    <!--        <h2>导航</h2>-->
    <!--        <Tree :data="treedata" @selectionChange="selection=$event"></Tree>-->
    <!--        <p v-if="selection">Selected: {{selection.text}}</p>-->

    <!--      </div>-->
    <!--    </LayoutPanel>-->
    <LayoutPanel region="center" style="height:100%">
      <div class="title">

        <div align="left">
          <LinkButton iconCls="icon-add" @click="addInfo">新增</LinkButton>
          <LinkButton iconCls="icon-remove">修改</LinkButton>
          <LinkButton iconCls="icon-save">导出</LinkButton>
<!--          <LinkButton iconCls="icon-cut" :disabled="true">Cut</LinkButton>-->
        </div>

<!--        <div class="main">-->
<!--          <div @click="openMask">打开弹窗</div>-->
<!--          <dialog-bar v-model="sendVal" type="danger" title="我是标题" content="我是内容" v-on:cancel="clickCancel()" @danger="clickDanger()" @confirm="clickConfirm()" dangerText="Delete"></dialog-bar>-->
<!--        </div>-->

<!--        <div style="margin-bottom:10px">-->
<!--          <Label for="c1">Pager on: </Label>-->
<!--          <ComboBox inputId="c1" style="width:120px"-->
<!--                    :data="pageOptions"-->
<!--                    v-model="pagePosition"-->
<!--                    :editable="false"-->
<!--                    :panelStyle="{height:'auto'}">-->
<!--          </ComboBox>-->
<!--        </div>-->
        <DataGrid style="height:100%"
                  :pagination="true"
                  :data="data"
                  :total="total"
                  :pageSize="pageSize"
                  :pagePosition="pagePosition">
          <GridColumn field="inv" title="Bank Name"></GridColumn>
          <GridColumn field="name" title="Outage Start Time"></GridColumn>
          <GridColumn field="amount" title="Outage End Time" align="right"></GridColumn>
          <GridColumn field="price" title="Status" align="right"></GridColumn>
          <GridColumn field="cost" title="Creator" align="right"></GridColumn>
          <GridColumn field="note" title="Create Date"></GridColumn>
          <GridColumn field="note" title="Editor"></GridColumn>
          <GridColumn field="note" title="Edit Date"></GridColumn>
        </DataGrid>

      </div>
    </LayoutPanel>
  </Layout>
  <!--  </div>-->
</template>

<script>
  // import dialogBar from './dialog.vue'
  export default {
    // components:{
    //   'dialog-bar': dialogBar,
    // },
    data() {
      return {
        // sendVal: false,
        total: 10000,
        pageSize: 20,
        data: [],
        pagePosition: "bottom",
        pageOptions: [
          {value: "bottom", text: "Bottom"},
          {value: "top", text: "Top"},
          {value: "both", text: "Both"}
        ],
        statusValue: "--请选择--",
        statusData: [
          {value: "0", text: "--请选择--"},
          {value: "1", text: "启用"},
          {value: "2", text: "停用"}
        ],
        bankValue: "--请选择--",
        bankData: [
          {value: "0", text: "--请选择--"},
          {value: "313100000013", text: "北京银行"},
          {value: "318110000014", text: "渤海银行"}
        ],
        treedata: this.getTreeData()
      };
    },
    created() {
      this.data = this.getData(this.total);
    },
    methods: {
      //
      // openMask(index){
      //   this.sendVal = true;
      // },
      // clickCancel(){
      //   console.log('点击了取消');
      // },
      // clickDanger(){
      //   console.log('这里是danger回调')
      // },
      // clickConfirm(){
      //   console.log('点击了confirm');
      // },
      addInfo () {
        this.$router.push('/bankInfo')
      },
      getData(total) {
        let data = [];
        for (let i = 1; i <= total; i++) {
          let amount = Math.floor(Math.random() * 1000);
          let time = Date();
          let price = Math.floor(Math.random() * 1000);
          data.push({
            inv: "Inv No " + i,
            name: "Name " + i,
            amount: time,
            price: price,
            cost: amount * price,
            note: "Note " + i
          });
        }
        return data;
      },

      getTreeData() {
        return [
          {
            id: 1,
            text: "My Documents",
            children: [
              {
                id: 11,
                text: "Photos",
                state: "closed",
                children: [
                  {
                    id: 111,
                    text: "Friend"
                  },
                  {
                    id: 112,
                    text: "Wife"
                  },
                  {
                    id: 113,
                    text: "Company"
                  }
                ]
              },
              {
                id: 12,
                text: "Program Files",
                children: [
                  {
                    id: 121,
                    text: "Intel"
                  },
                  {
                    id: 122,
                    text: "Java"
                  },
                  {
                    id: 123,
                    text: "Microsoft Office"
                  },
                  {
                    id: 124,
                    text: "Games"
                  }
                ]
              },
              {
                id: 13,
                text: "index.html"
              },
              {
                id: 14,
                text: "about.html"
              },
              {
                id: 15,
                text: "welcome.html"
              }
            ]
          }
        ];
      }

    }
  };
</script>
<style>
  .title {
    text-align: center;
    margin-top: 10px;
  }
</style>
