import React, { Component } from 'react'
import { Link } from 'react-router-dom'

export default class Confirmation extends Component {
  render() {
    return (
      <div>
        <Link to ="ticket">
        <button onClick={this.handlePay}>Confirm</button></Link>
      </div>
    )
  }
}
