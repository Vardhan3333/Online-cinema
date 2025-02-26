import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Service1 from '../service/service1';

export default class Payment extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cardNumber: '',
      cardHolder: '',
      expiryDate: '',
      cvv: '',
      result: '', // Initialize an empty string
      errors: {}, // Initialize an empty object for errors
    };
  }

  // Function to validate the payment form
  validateForm = () => {
    const errors = {};
    const { cardNumber, cardHolder, expiryDate, cvv } = this.state;

    // Card Number validation (dummy validation for example)
    if (!cardNumber) {
      errors.cardNumber = 'Card Number is required';
    } else if (!/^\d{16}$/.test(cardNumber)) {
      errors.cardNumber = 'Card Number must be 16 digits';
    }

    // Card Holder validation
    if (!cardHolder) {
      errors.cardHolder = 'Card Holder is required';
    }

    // Expiry Date validation (dummy validation for example)
    if (!expiryDate) {
      errors.expiryDate = 'Expiry Date is required';
    } else if (!/^\d{2}\/\d{2}$/.test(expiryDate)) {
      errors.expiryDate = 'Expiry Date must be in MM/YY format';
    }

    // CVV validation (dummy validation for example)
    if (!cvv) {
      errors.cvv = 'CVV is required';
    } else if (!/^\d{3}$/.test(cvv)) {
      errors.cvv = 'CVV must be 3 digits';
    }

    // Check if there are any errors
    if (Object.keys(errors).length === 0) {
      return null; // No errors
    } else {
      return errors; // Errors object
    }
  };

  handleInputChange = (e) => {
    // Update state with the form input values
    this.setState({ [e.target.name]: e.target.value });
  }

  handlePay = () => {
    // Validate the form
    const errors = this.validateForm();

    if (errors) {
      // If there are errors, update the state with the error object
      this.setState({ errors });
    } else {
      // Set the 'result' state to 'success' if there are no errors
      this.setState({ result: 'success' });
    
      // Send the 'result' string to the backend
      this.sendResultToBackend('success');
    
    

      window.location.href = '/theatre/payment/confirm';
    }
    
  }

  handleCancel = () => {
    // Set the 'result' state to 'cancel'
    this.setState({ result: 'cancel' });

    // Send the 'result' string to the backend
    this.sendResultToBackend('cancel');
  }

  sendResultToBackend = (result) => {
    // Send a request to the backend with the 'result' string
    const formData = new FormData();
    formData.append('result', result);
    console.log(result);
    Service1.sendResult(formData)
      .then((response) => {
        console.log('Result sent to the backend:', response.data);
      })
      .catch((error) => {
        console.error('Error sending result:', error);
      });
  }

  render() {
    const { cardNumber, cardHolder, expiryDate, cvv, result, errors } = this.state;

    return (
      <div>
        <h2>Payment Details</h2>
        <form>
          <div>
            <label>Card Number:</label>
            <input
              type="text"
              name="cardNumber"
              value={cardNumber}
              onChange={this.handleInputChange}
            />
            {errors.cardNumber && <span className="error">{errors.cardNumber}</span>}
          </div>
          <div>
            <label>Card Holder:</label>
            <input
              type="text"
              name="cardHolder"
              value={cardHolder}
              onChange={this.handleInputChange}
            />
            {errors.cardHolder && <span className="error">{errors.cardHolder}</span>}
          </div>
          <div>
            <label>Expiry Date (MM/YY):</label>
            <input
              type="text"
              name="expiryDate"
              value={expiryDate}
              onChange={this.handleInputChange}
            />
            {errors.expiryDate && <span className="error">{errors.expiryDate}</span>}
          </div>
          <div>
            <label>CVV:</label>
            <input
              type="text"
              name="cvv"
              value={cvv}
              onChange={this.handleInputChange}
            />
            {errors.cvv && <span className="error">{errors.cvv}</span>}
          </div>
        </form>
        
          <button onClick={this.handlePay}>Pay</button>
        <Link to="theatre">
          <button onClick={this.handleCancel}>Cancel</button>
        </Link>
        {result && <div className="payment-result">Payment Result: {result}</div>}
      </div>
    );
  }
}
