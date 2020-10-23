import React, { Component } from "react";

class AddProduct extends Component {
  state = {
    name: "",
    price: "",
    unit: "",
    image: "",
  };

  handleFieldChange = (field, event) => {
    this.setState({
      [field]: event.target.value,
    });
  };

  handleFormSubmit = (e) => {
    e.preventDefault();
    alert(JSON.stringify(this.state));
  };

  render() {
    return (
      <form onSubmit={this.handleFormSubmit}>
        <p>添加货品</p>
        <div>
          <p>名称：</p>
          <input
            type="text"
            placeholder="名称"
            value={this.state.name}
            id="name"
            onChange={(e) =>this.handleFieldChange("name",e)}
          />

          <p>价格：</p>
          <input
            type="text"
            placeholder="price"
            value={this.state.price}
            id="price"
            onChange={(e) =>this.handleFieldChange("price",e)}
          />
          <p>单位：</p>
          <input
            type="text"
            placeholder="单位"
            value={this.state.unit}
            id="unit"
            onChange={(e) =>this.handleFieldChange("unit",e)}
          />
          <p>图片：</p>
          <input
            type="text"
            placeholder="图片"
            value={this.state.image}
            id="image"
            onChange={(e) =>this.handleFieldChange("image",e)}
          />
          <br/>
           <input type="submit" ></input>
        </div>
       
      </form>
    );
  }
}

export default AddProduct;
