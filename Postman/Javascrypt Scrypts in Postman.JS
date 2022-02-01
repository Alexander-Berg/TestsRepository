//Check if there is a Postman variable in the current scope:
pm.variables.has(variableName:String):function → Boolean

//Get the value of the Postman variable with the specified name:
pm.variables.get(variableName:String):function → *

//Set a local variable with the specified name and value:
pm.variables.set(variableName:String, variableValue:*):function

//Return the resolved value of a dynamic variable inside a script using the syntax {{$variableName}}:
pm.variables.replaceIn(variableName:String):function: → *

//For example:
const stringWithVars = pm.variables.replaceIn("Hi, my name is {{$randomFirstName}}");
console.log(stringWithVars);

//Return an object containing all variables with their values in the current scope. Based on the order of precedence, this will contain variables from multiple scopes.
pm.variables.toObject():function → Object

//collection var 'score' = 1
//environment var 'score' = 2

//first request run
console.log(pm.variables.get('score'));//outputs 2
console.log(pm.collectionVariables.get('score'));//outputs 1
console.log(pm.environment.get('score'));//outputs 2

//second request run
pm.variables.set('score', 3);//local var
console.log(pm.variables.get('score'));//outputs 3

//third request run
console.log(pm.variables.get('score'));//outputs 2

//The name of the active environment:
pm.environment.name:String

//Check whether the environment has a variable with the specified name:
pm.environment.has(variableName:String):function → Boolean

//Get the variable with the specified name in the active environment:
pm.environment.get(variableName:String):function → *

//Set the variable with the specified name and value in the active environment:
pm.environment.set(variableName:String, variableValue:*):function

//Return the resolved value of a dynamic variable inside a script using the syntax {{$variableName}}:
pm.environment.replaceIn(variableName:String):function → *

//For example:

//environment has vars firstName and age
const stringWithVars = pm.environment.replaceIn("Hi, my name is {{firstName}} and I am {{age}}.");
console.log(stringWithVars);

//Return all variables with their values in the active environment in a single object:
pm.environment.toObject():function → Object

//Remove a variable from the active environment, specifying the variable by name:
pm.environment.unset(variableName:String):function

//Clear all variables in the active environment:
pm.environment.clear():function

//Using collection variables in scripts
//Your scripts can use the pm.collectionVariables methods to access and manipulate variables in the collection.

//Check whether there is a variable in the collection with the specified name:
pm.collectionVariables.has(variableName:String):function → Boolean
//Return the value of the collection variable with the specified name:
pm.collectionVariables.get(variableName:String):function → *
//Set a collection variable with the specified name and value:
pm.collectionVariables.set(variableName:String, variableValue:*):function
//Return the resolved value of a dynamic variable inside a script using the syntax {{$variableName}}:
pm.collectionVariables.replaceIn(variableName:String):function → *
//For example:

//collection has vars firstName and age
const stringWithVars = pm.collectionVariables.replaceIn("Hi, my name is {{firstName}} and I am {{age}}.");
console.log(stringWithVars);
//Return all variables with their values in the collection in an object:
pm.collectionVariables.toObject():function → Object

//Remove the specified variable from the collection:
pm.collectionVariables.unset(variableName:String):function

//Clear all variables from the collection:
pm.collectionVariables.clear():function

//Check where there is a global variable with the specified name:
pm.globals.has(variableName:String):function → Boolean

//Return the value of the global variable with the specified name:
pm.globals.get(variableName:String):function → *

//Set a global variable with specified name and value:
pm.globals.set(variableName:String, variableValue:*):function

//Return the resolved value of a dynamic variable inside a script using the syntax {{$variableName}}:
pm.globals.replaceIn(variableName:String):function → String

//For example:

//globals include vars firstName and age
const stringWithVars = pm.globals.replaceIn("Hi, my name is {{firstName}} and I am {{age}}.");
console.log(stringWithVars);

//Return all global variables and their values in an object:
pm.globals.toObject():function → Object

//Remove the specified global variable:
pm.globals.unset(variableName:String):function

//Clear all global variables in the workspace:
pm.globals.clear():function

//Check whether a variable with the specified name exists in the current iteration data:
pm.iterationData.has(variableName:String):function → boolean

//Return a variable from the iteration data with the specified name:
pm.iterationData.get(variableName:String):function → *

//Return the iteration data variables in an object:
pm.iterationData.toObject():function → Object

//Convert the iterationData object to JSON format:
pm.iterationData.toJSON():function → *

//Remove the specified variable:
pm.iterationData.unset(key:String):function

//The request URL:
pm.request.url:Url

//The list of headers for the current request:
pm.request.headers:HeaderList

//The HTTP request method:
pm.request.method:String

//The data in the request body. This object is immutable and cannot be modified from scripts:
pm.request.body:RequestBody

//Add a header with the specified name and value for the current request:
pm.request.headers.add(header:Header):function

//For example:
pm.request.headers.add({
  key: "client-id",
  value: "abcdef"
});

//Delete the request header with the specified name:
pm.request.headers.remove(headerName:String):function

//Insert the specified header name and value (if the header does not exist, otherwise the already existing header will update to the new value):
pm.request.headers.upsert({key: headerName:String, value: headerValue:String}):function)

//The response status code:
pm.response.code:Number
//The status text string:
pm.response.status:String
//The list of response headers:
pm.response.headers:HeaderList
//The time the response took to receive in milliseconds:
pm.response.responseTime:Number
//The size of the response received:
pm.response.responseSize:Number
//The response text:
pm.response.text():Function → String
//The response JSON, which you can use to drill down into the properties received:
pm.response.json():Function → Object

//The event, which will be either "prerequest" or "test" depending on where the script is executing within the request:
pm.info.eventName:String
//The value of the current iteration:
pm.info.iteration:Number
//The total number of iterations that are scheduled to run:
pm.info.iterationCount:Number
//The saved name of the request running:
pm.info.requestName:String
//A unique GUID that identifies the running request:
pm.info.requestId:String

//Check whether a particular cookie (specified by name) exists for the requested domain:
pm.cookies.has(cookieName:String):Function → Boolean
//Get the value of the specified cookie:
pm.cookies.get(cookieName:String):Function → String
//Get a copy of all cookies and their values in an object. Returns any cookies that are defined for the request domain and path:
pm.cookies.toObject():Function → Object

//Access the cookie jar object:
pm.cookies.jar():Function → Object
//For example:

const jar = pm.cookies.jar();
//cookie methods...
//Set a cookie using name and value:
jar.set(URL:String, cookie name:String, cookie value:String, callback(error, cookie)):Function → Object
//Set a cookie using PostmanCookie or a compatible object:
jar.set(URL:String, { name:String, value:String, httpOnly:Bool }, callback(error, cookie)):Function → Object
//For example:

const jar = pm.cookies.jar();
jar.set("httpbin.org", "session-id", "abc123", (error, cookie) => {
  if (error) {
    console.error(`An error occurred: ${error}`);
  } else {
    console.log(`Cookie saved: ${cookie}`);
  }
});
//Get a cookie from the cookie jar:
jar.get(URL:String, cookieName:String, callback (error, value)):Function → Object
//Get all the cookies from the cookie jar. The cookies are available in the callback function:
jar.getAll(URL:String, callback (error, cookies)):Function
//Remove a cookie:
jar.unset(URL:String, token:String, callback(error)):Function → Object
//Clear all cookies from the cookie jar:
jar.clear(URL:String, callback (error)):Function → Object

//You can pass the pm.sendRequest method a URL string, or can provide a complete request configuration in JSON including headers, method, body, and more.

// Example with a plain string URL
pm.sendRequest('https://postman-echo.com/get', (error, response) => {
  if (error) {
    console.log(error);
  } else {
  console.log(response);
  }
});

// Example with a full-fledged request
const postRequest = {
  url: 'https://postman-echo.com/post',
  method: 'POST',
  header: {
    'Content-Type': 'application/json',
    'X-Foo': 'bar'
  },
  body: {
    mode: 'raw',
    raw: JSON.stringify({ key: 'this is json' })
  }
};
pm.sendRequest(postRequest, (error, response) => {
  console.log(error ? error : response.json());
});

// Example containing a test
pm.sendRequest('https://postman-echo.com/get', (error, response) => {
  if (error) {
    console.log(error);
  }

  pm.test('response should be okay to process', () => {
    pm.expect(error).to.equal(null);
    pm.expect(response).to.have.property('code', 200);
    pm.expect(response).to.have.property('status', 'OK');
  });
});

//Run the specified request after this one (the request name as defined in the collection e.g. "Get customers"):
postman.setNextRequest(requestName:String):Function
//Run the specified request after this one (the request ID returned by pm.info.requestId):
postman.setNextRequest(requestId:String):Function
//For example:

//script in another request calls:
//pm.environment.set('next', pm.info.requestId)
postman.setNextRequest(pm.environment.get('next'));

//Use pm.visualizer.set to specify a template to display response data in the visualizer.

pm.visualizer.set(layout:String, data:Object, options:Object):Function

//layout required
//Handlebars HTML template string
//data optional
//JSON object that binds to the template and you can access it inside the template string
//options optional
Options object for Handlebars.compile()
//Example usage:

var template = `<p>{{res.info}}</p>`;
pm.visualizer.set(template, {
    res: pm.response.json()
});

//Use pm.getData to retrieve response data inside a visualization template string.

pm.getData(callback):Function
//The callback function accepts two parameters:

//error
//Any error detail
//data
//Data passed to the template by pm.visualizer.set
//Example usage:

pm.getData(function (error, data) {
  var value = data.res.info;
});

//Writing test assertions
pm.test(testName:String, specFunction:Function):Function
//You can use pm.test to write test specifications inside either the Pre-request or Tests scripts. Tests include a name and assertion—Postman will output test results as part of the response.

//The pm.test method returns the pm object, making the call chainable. The following sample test checks that a response is valid to proceed.

pm.test("response should be okay to process", function () {
  pm.response.to.not.be.error;
  pm.response.to.have.jsonBody('');
  pm.response.to.not.have.jsonBody('error');
});
//An optional done callback can be passed to pm.test, to test asynchronous functions.

pm.test('async test', function (done) {
  setTimeout(() => {
    pm.expect(pm.response.code).to.equal(200);
    done();
  }, 1500);
});
//Get the total number of tests executed from a specific location in code:
pm.test.index():Function → Number
//The pm.expect method allows you to write assertions on your response data, using ChaiJS expect BDD syntax.

pm.expect(assertion:*):Function → Assertion
//You can also use pm.response.to.have.* and pm.response.to.be.* to build your assertions.

//Using external libraries
require(moduleName:String):function → *
/*The require method allows you to use the sandbox built-in library modules. The list of available libraries is listed below with links to the corresponding documentation.

ajv
atob
btoa
chai
cheerio
crypto-js
csv-parse/lib/sync
lodash (The built-in _ object v3.10.1 exists in the sandbox by default. Use require to load the latest version.)
moment
postman-collection
tv4
uuid
xml2js
A number of NodeJS modules are also available to use in the sandbox:

path
assert
buffer
util
url
punycode
querystring
string-decoder
stream
timers
events
In order to use a library, call the require method, pass the module name as a parameter, and assign the return object from the method to a variable/*
