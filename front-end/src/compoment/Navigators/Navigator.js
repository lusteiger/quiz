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
class Navigator extends Component {
  render() {
    return (
      <BrowserRouter>
        <Router>
          <Link to="/">商城</Link>
          <Link to="/Orders">订单</Link>
          <Link to="/AddProduct">添加商品</Link>
          <Switch>
            <Route exact path="/" component={ProductsList} />
            <Route exact path="/AddProduct" component={AddProduct} />
            <Route exact path="/Orders" component={Orders} />
          </Switch>
        </Router>
      </BrowserRouter>
    );
  }
}

export default Navigator;
