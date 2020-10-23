import React, { Component } from "react";
import { Button, Table } from "antd";

class orders extends Component {
  state = {
    orderId:"12345",
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
        unit: "￥3.00",
        number: "1",
      }
      
    ],
  };

  OrderInfo =(props) => {
    var orderId = this.props.orderId ;
    
      return (
        <div>
          订单编号：<p>{this.props.orderId}</p>
        </div>
      );
    
  };

  render() {
    return (
      <div>
      <this.OrderInfo orderId={this.state.orderId}></this.OrderInfo>
      <Table
        columns={this.state.column}
        dataSource={this.state.data}
        bordered
      />
      {this.state.orderId}
      </div>
    );
  }
}

export default orders;
