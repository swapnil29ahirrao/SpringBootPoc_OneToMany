# SpringBootPoc_OneToMany
/**********************************************************************************************************************************/
Request Creation from Employee side:
URL: http://localhost:8080/Employee
Json: 
{
    "emp_id": 2,
    "emp_name": "test",
    "emp_salary": 200,
    "age": 20,
    "addList": [
        {
            "add_Id": 2,
            "addressType": "off",
            "lane": "l1",
            "state": "Mh",
            "pincode": 411058
        }
    ]
}

/**********************************************************************************************************************************/
Request Creation from Address side:
URL: http://localhost:8080/address
Json:
{
    "add_Id": 2,
    "addressType": "off",
    "lane": "l1",
    "state": "Mh",
    "pincode": 411058,
    "emp": {
        "emp_id": 2,
        "emp_name": "test",
        "emp_salary": 200,
        "age": 20
    }
}
