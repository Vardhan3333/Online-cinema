import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import LocationSearch from './LocationSearch'
import { UserNavbar } from './UserNavbar'

export default class User extends Component {
  
  render() {
    return (
      <div>
       <UserNavbar/>
       <LocationSearch/>
      </div>
    )
  }
}
