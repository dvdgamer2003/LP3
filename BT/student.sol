// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract studentData{
    // structure
    struct student{
        string name;
        uint256 roll;
    }

    // array
    student[] public studentarr;

    function addstudent(string memory name,uint roll) public {
        for(uint i=0;i<studentarr.length;i++){
            if(studentarr[i].roll==roll){
                revert("student with this roll no already exist.");
            }
        }
        studentarr.push(student(name,roll));
    }

    function getstudentslength() public view returns(uint){
        return studentarr.length;
    }

    function displayarr() public view returns(student[] memory){
        return studentarr;
    }

    function getstudent(uint idx) public view returns (student memory){
        require(idx<studentarr.length,"index out of bound.");
        return studentarr[idx];
    }

    // fallback
    fallback() external payable {
        // this function will handle external function call that were not in this contract
    }

    receive() external payable {
        // this function will handle ether sent by external user but without data mention
    }

}