import React, { Component } from "react";
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Link,
  BrowserRouter,
} from "react-router-dom";
import "./Navigators.css";
import Orders from "../orders/orders";
import ProductsList from "../products/productsList";
import AddProduct from "../products/AddProduct";
import { Menu } from "antd";
class Navigator extends Component {
  render() {
    return (
      <BrowserRouter>
        <Menu theme="dark" mode="horizontal" defaultSelectedKeys={["2"]}>
          <Menu.Item key="1">
            <Link to="/">商城</Link>
          </Menu.Item>
          <Menu.Item key="2">
            <Link to="/Orders">订单</Link>
          </Menu.Item>
          <Menu.Item key="3">
            <Link to="/AddProduct">添加商品</Link>
          </Menu.Item>
        </Menu>

        <Switch>
          <Route exact path="/" component={ProductsList} />
          <Route exact path="/AddProduct" component={AddProduct} />
          <Route exact path="/Orders" component={Orders} />
        </Switch>
      </BrowserRouter>
    );
  }
}

export default Navigator;
