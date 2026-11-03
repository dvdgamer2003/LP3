// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Bank{

    uint256 balance=0;
    address public accOwner;

    constructor(){
        accOwner=msg.sender;
    }

    // Deposit
    function Deposit() public payable {
        require(accOwner==msg.sender,"You are not an account owner");
        require(msg.value>0 , "Amount should be greater than 0.");
        balance+=msg.value;
    }

    // withdraw
    function withdraw() public payable {
        require(accOwner==msg.sender,"You are not an account owner");
        require(msg.value>0 , "withdraw money should be greater than 0.");
        balance-=msg.value;
    }

    // showbalance
    function showBalance() public view returns(uint256) {
        require(accOwner==msg.sender,"You are not an account owner");
        return balance;
    }
}