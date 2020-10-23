import React, { Component } from "react";
import { Button, Table } from "antd";
import "antd/dist/antd.css";
class orders extends Component {
  state = {
    column: [
      {
        title: "#",
        dataIndex: "id",
        render: (text) => <a>{text}</a>,
      },
      {
        title: "名称",
        dataIndex: "name",
        align: "right",
      },
      {
        title: "单价",
        className: "column-money",
        dataIndex: "unit",
      },
      {
        title: "数量",
        dataIndex: "number",
      },
    ],

    data: [
      {
        id: "1",
        name: "可乐",
        price: "￥3.00",
        number: "1",
      }
      
    ],
  };

  render() {
    return (
      <Table
        columns={this.state.column}
        dataSource={this.state.data}
        bordered
        title={() => "订单编号" }
      />
    );
  }
}

export default orders;
