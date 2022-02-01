pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
  });

  //The following code is an alternative way of achieving the same test as the one above using the expect syntax:

pm.test("Status code is 200", () => {
  pm.expect(pm.response.code).to.eql(200);
});

//Your tests can include multiple assertions as part of a single test. Use this to group together related assertions:

pm.test("The response has all properties", () => {
    //parse the response JSON and test three properties
    const responseJson = pm.response.json();
    pm.expect(responseJson.type).to.eql('vip');
    pm.expect(responseJson.name).to.be.a('string');
    pm.expect(responseJson.id).to.have.lengthOf(1);
});

//To parse JSON data, use the following syntax:

const responseJson = pm.response.json();

//To parse XML, use the following:

const responseJson = xml2Json(pm.response.text());

//To parse CSV, use the CSV parse utility:

const parse = require('csv-parse/lib/sync');
const responseJson = parse(pm.response.text());

//To parse HTML, use cheerio:

const $ = cheerio.load(pm.response.text());
//output the html for testing
console.log($.html());

//Test if the response body contains a string:

pm.test("Body contains string",() => {
  pm.expect(pm.response.text()).to.include("customer_id");
});

//Test if a response matches a string (which will typically only be effective with short responses):
pm.test("Body is string", function () {
    pm.response.to.have.body("whole-body-text");
  });

  //Check for particular values in the response body:

pm.test("Person is Jane", () => {
  const responseJson = pm.response.json();
  pm.expect(responseJson.name).to.eql("Jane");
  pm.expect(responseJson.age).to.eql(23);
});

//Test for the response status code:

pm.test("Status code is 201", () => {
  pm.response.to.have.status(201);
});

//If you want to test for the status code being one of a set, include them all in an array and use oneOf:

pm.test("Successful POST request", () => {
  pm.expect(pm.response.code).to.be.oneOf([201,202]);
});

//Check the status code text:

pm.test("Status code name has string", () => {
  pm.response.to.have.status("Created");
});

//Check that a response header is present:

pm.test("Content-Type header is present", () => {
  pm.response.to.have.header("Content-Type");
});

//Test for a response header having a particular value:

pm.test("Content-Type header is application/json", () => {
    pm.expect(pm.response.headers.get('Content-Type')).to.eql('application/json');
  });

  //Test if a cookie is present in the response:

  pm.test("Cookie JSESSIONID is present", () => {
    pm.expect(pm.cookies.has('JSESSIONID')).to.be.true;
  });

//Test for a particular cookie value:

pm.test("Cookie isLoggedIn has value 1", () => {
  pm.expect(pm.cookies.get('isLoggedIn')).to.eql('1');
});

//Test for the response time to be within a specified range:

pm.test("Response time is less than 200ms", () => {
  pm.expect(pm.response.responseTime).to.be.below(200);
});

//Check if a response property has the same value as a variable (in this case an environment variable):

pm.test("Response property matches environment variable", function () {
  pm.expect(pm.response.json().name).to.eql(pm.environment.get("name"));
});

//Test the type of any part of the response:

/* response has this structure:
{
  "name": "Jane",
  "age": 29,
  "hobbies": [
    "skating",
    "painting"
  ],
  "email": null
}
*/
const jsonData = pm.response.json();
pm.test("Test data type of the response", () => {
  pm.expect(jsonData).to.be.an("object");
  pm.expect(jsonData.name).to.be.a("string");
  pm.expect(jsonData.age).to.be.a("number");
  pm.expect(jsonData.hobbies).to.be.an("array");
  pm.expect(jsonData.website).to.be.undefined;
  pm.expect(jsonData.email).to.be.null;
});

//Check if an array is empty, and if it contains particular items:

/*
response has this structure:
{
  "errors": [],
  "areas": [ "goods", "services" ],
  "settings": [
    {
      "type": "notification",
      "detail": [ "email", "sms" ]
    },
    {
      "type": "visual",
      "detail": [ "light", "large" ]
    }
  ]
}
*/

const jsonData = pm.response.json();
pm.test("Test array properties", () => {
    //errors array is empty
  pm.expect(jsonData.errors).to.be.empty;
    //areas includes "goods"
  pm.expect(jsonData.areas).to.include("goods");
    //get the notification settings object
  const notificationSettings = jsonData.settings.find
      (m => m.type === "notification");
  pm.expect(notificationSettings)
    .to.be.an("object", "Could not find the setting");
    //detail array should include "sms"
  pm.expect(notificationSettings.detail).to.include("sms");
    //detail array should include all listed
  pm.expect(notificationSettings.detail)
    .to.have.members(["email", "sms"]);
});

//Assert that an object contains keys or properties:

pm.expect({a: 1, b: 2}).to.have.all.keys('a', 'b');
pm.expect({a: 1, b: 2}).to.have.any.keys('a', 'b');
pm.expect({a: 1, b: 2}).to.not.have.any.keys('c', 'd');
pm.expect({a: 1}).to.have.property('a');
pm.expect({a: 1, b: 2}).to.be.an('object')
  .that.has.all.keys('a', 'b');

//Check a response value against a list of valid options:

  pm.test("Value is in valid list", () => {
    pm.expect(pm.response.json().type)
      .to.be.oneOf(["Subscriber", "Customer", "User"]);
  });

//Check that an object is part of a parent object:

  /*
  response has the following structure:
  {
    "id": "d8893057-3e91-4cdd-a36f-a0af460b6373",
    "created": true,
    "errors": []
  }
  */
  
  pm.test("Object is contained", () => {
    const expectedObject = {
      "created": true,
      "errors": []
    };
    pm.expect(pm.response.json()).to.deep.include(expectedObject);
  });

//Check the active (currently selected) environment in Postman:

pm.test("Check the active environment", () => {
  pm.expect(pm.environment.name).to.eql("Production");
});

//Log the value of a variable or response property:

console.log(pm.collectionVariables.get("name"));
console.log(pm.response.json().name);

//Log the type of a variable or response property:

console.log(typeof pm.response.json().id);

//Use console logs to mark code execution, sometimes known as "trace statements":

if (pm.response.json().id) {
  console.log("id was found!");
  // do something
} else {
  console.log("no id ...");
  //do something else
}

//You may encounter the AssertionError: expected <value> to deeply equal '<value>'. For example, this would arise with the following code:

pm.expect(1).to.eql("1");

//You may encounter the ReferenceError: jsonData is not defined issue. 
//This typically happens when you are attempting to reference a JSON object that hasn't been declared or is outside the scope of your test code.

pm.test("Test 1", () => {
  const jsonData = pm.response.json();
  pm.expect(jsonData.name).to.eql("John");
});

pm.test("Test 2", () => {
  pm.expect(jsonData.age).to.eql(29); // jsonData is not defined
});

//You may encounter the AssertionError: expected undefined to deeply equal.. issue.
// Typically this happens when you are referring to a property that doesn't exist or is out of scope.

pm.expect(jsonData.name).to.eql("John");

//There may be occasions where you expect a test to fail and it doesn't.

//test function not properly defined - missing second parameter
pm.test("Not failing", function () {
    pm.expect(true).to.eql(false);
});

//Carry out JSON schema validation with Tiny Validator V4 (tv4):

const schema = {
 "items": {
 "type": "boolean"
 }
};
const data1 = [true, false];
const data2 = [true, 123];

pm.test('Schema is valid', function() {
  pm.expect(tv4.validate(data1, schema)).to.be.true;
  pm.expect(tv4.validate(data2, schema)).to.be.true;
});

//Validate JSON schema with the the Ajv JSON schema validator:

const schema = {
  "properties": {
    "alpha": {
      "type": "boolean"
    }
  }
};
pm.test('Schema is valid', function() {
  pm.response.to.have.jsonSchema(schema);
});

//Send a request from your test code and log the response.

pm.sendRequest("https://postman-echo.com/get", function (err, response) {
    console.log(response.json());
});

