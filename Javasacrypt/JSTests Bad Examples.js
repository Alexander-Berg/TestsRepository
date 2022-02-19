/////////////////////////////////////Anti-Pattern Examples//////////////////////////////////////
////////////////////////////////////Section 1: The Test Anatomy////////////////////////////////



//Anti-Pattern Example: No separation, one bulk, harder to interpret
test("Should be classified as premium", () => {
    const customerToClassify = { spent: 505, joined: new Date(), id: 1 };
    const DBStub = sinon.stub(dataAccess, "getCustomer").reply({ id: 1, classification: "regular" });
    const receivedClassification = customerClassifier.classifyCustomer(customerToClassify);
    expect(receivedClassification).toMatch("premium");
  });

//Anti-Pattern Example: The reader must skim through not so short, and imperative code just to get the test story
test("When asking for an admin, ensure only ordered admins in results", () => {
    //assuming we've added here two admins "admin1", "admin2" and "user1"
    const allAdmins = getUsers({ adminOnly: true });
  
    let admin1Found,
      adming2Found = false;
  
    allAdmins.forEach(aSingleUser => {
      if (aSingleUser === "user1") {
        assert.notEqual(aSingleUser, "user1", "A user was found and not admin");
      }
      if (aSingleUser === "admin1") {
        admin1Found = true;
      }
      if (aSingleUser === "admin2") {
        admin2Found = true;
      }
    });
  
    if (!admin1Found || !admin2Found) {
      throw new Error("Not all admins were returned");
    }
  });

// Anti-Pattern Example: A test case is testing the internals for no good reason
class ProductService {
    //this method is only used internally
    //Change this name will make the tests fail
    calculateVATAdd(priceWithoutVAT) {
      return { finalPrice: priceWithoutVAT * 1.2 };
      //Change the result format or key name above will make the tests fail
    }
    //public method
    getPrice(productId) {
      const desiredProduct = DB.getProduct(productId);
      finalPrice = this.calculateVATAdd(desiredProduct.price).finalPrice;
      return finalPrice;
    }
  }
  
  it("White-box test: When the internal methods get 0 vat, it return 0 response", async () => {
    //There's no requirement to allow users to calculate the VAT, only show the final price. Nevertheless we falsely insist here to test the class internals
    expect(new ProductService().calculateVATAdd(0).finalPrice).to.equal(0);
  });

//Anti-pattern example: Mocks focus on the internals
it("When a valid product is about to be deleted, ensure data access DAL was called once, with the right product and right config", async () => {
    //Assume we already added a product
    const dataAccessMock = sinon.mock(DAL);
    //hmmm BAD: testing the internals is actually our main goal here, not just a side-effect
    dataAccessMock
      .expects("deleteProduct")
      .once()
      .withArgs(DBConfig, theProductWeJustAdded, true, false);
    new ProductService().deletePrice(theProductWeJustAdded);
    dataAccessMock.verify();
  });

//Anti-Pattern Example: A test suite that passes due to non-realistic data
const addProduct = (name, price) => {
    const productNameRegexNoSpace = /^\S*$/; //no white-space allowed
  
    if (!productNameRegexNoSpace.test(name)) return false; //this path never reached due to dull input
  
    //some logic here
    return true;
  };
  
  test("Wrong: When adding new product with valid properties, get successful confirmation", async () => {
    //The string "Foo" which is used in all tests never triggers a false result
    const addProductResult = addProduct("Foo", 5);
    expect(addProductResult).toBe(true);
    //Positive-false: the operation succeeded because we never tried with long
    //product name including spaces
  });

 // Anti-Pattern Example: Coupling our test to unseen 2000 lines of code
 it("TestJavaScript.com is renderd correctly", () => {
    //Arrange
  
    //Act
    const receivedPage = renderer
      .create(<DisplayPage page="http://www.testjavascript.com"> Test JavaScript </DisplayPage>)
      .toJSON();
  
    //Assert
    expect(receivedPage).toMatchSnapshot();
    //We now implicitly maintain a 2000 lines long document
    //every additional line break or comment - will break this test
  });

// Anti-Pattern Example: tests are not independent and rely on some global hook to feed global DB data
before(async () => {
    //adding sites and admins data to our DB. Where is the data? outside. At some external json or migration framework
    await DB.AddSeedDataFromJson('seed.json');
  });
  it("When updating site name, get successful confirmation", async () => {
    //I know that site name "portal" exists - I saw it in the seed files
    const siteToUpdate = await SiteService.getSiteByName("Portal");
    const updateNameResult = await SiteService.changeName(siteToUpdate, "newName");
    expect(updateNameResult).to.be(true);
  });
  it("When querying by site name, get the right site", async () => {
    //I know that site name "portal" exists - I saw it in the seed files
    const siteToCheck = await SiteService.getSiteByName("Portal");
    expect(siteToCheck.name).to.be.equal("Portal"); //Failure! The previous test change the name :[
  });

//Anti-pattern Example: A long test case that tries to assert the existence of error with try-catch
it("When no product name, it throws error 400", async () => {
    let errorWeExceptFor = null;
    try {
      const result = await addNewProduct({});
    } catch (error) {
      expect(error.code).to.equal("InvalidInput");
      errorWeExceptFor = error;
    }
    expect(errorWeExceptFor).not.to.be.null;
    //if this assertion fails, the tests results/reports will only show
    //that some value is null, there won't be a word about a missing Exception
  });

//Anti-pattern Example: A flat list of tests will make it harder for the reader to identify the user stories and correlate failing tests
test("Then the response status should decline", () => {});

test("Then it should send email", () => {});

test("Then there should not be a new transfer record", () => {});

////////////////////////////////Section 2️⃣: Backend Testing////////////////////////////
//Anti-Pattern Example: tests are not independent and rely on some global hook to feed global DB data
before(async () => {
    //adding sites and admins data to our DB. Where is the data? outside. At some external json or migration framework
    await DB.AddSeedDataFromJson('seed.json');
  });
  it("When updating site name, get successful confirmation", async () => {
    //I know that site name "portal" exists - I saw it in the seed files
    const siteToUpdate = await SiteService.getSiteByName("Portal");
    const updateNameResult = await SiteService.changeName(siteToUpdate, "newName");
    expect(updateNameResult).to.be(true);
  });
  it("When querying by site name, get the right site", async () => {
    //I know that site name "portal" exists - I saw it in the seed files
    const siteToCheck = await SiteService.getSiteByName("Portal");
    expect(siteToCheck.name).to.be.equal("Portal"); //Failure! The previous test change the name :[
  });


/////////////////////////////////////Section 3️⃣: Frontend Testing//////////////////////
  //Anti-Pattern Example: Assertion mix UI details and data
  test("When flagging to show only VIP, should display only VIP members", () => {
    // Arrange
    const allUsers = [{ id: 1, name: "Yoni Goldberg", vip: false }, { id: 2, name: "John Doe", vip: true }];
  
    // Act
    const { getAllByTestId } = render(<UsersList users={allUsers} showOnlyVIP={true} />);
  
    // Assert - Mix UI & data in assertion
    expect(getAllByTestId("user")).toEqual('[<li data-test-id="user">John Doe</li>]');
  });

  //Anti-Pattern Example: Relying on CSS attributes
  <!-- the markup code (part of React component) -->
<span id="metric" className="d-flex-column">{value}</span>
<!-- what if the designer changes the classs? -->

// this exammple is using enzyme
test("Whenever no data is passed, error metric shows zero", () => {
    // ...
  
    expect(wrapper.find("[className='d-flex-column']").text()).toBe("0");
  });

// Anti-Pattern Example: Mocking the reality with shallow rendering
test("Shallow/mocked approach: When clicked to show filters, filters are displayed", () => {
    // Arrange
    const wrapper = shallow(<Calendar showFilters={false} title="Choose Filter" />);
  
    // Act
    wrapper
      .find("filtersPanel")
      .instance()
      .showFilters();
    // Tap into the internals, bypass the UI and invoke a method. White-box approach
  
    // Assert
    expect(wrapper.find("Filter").props()).toEqual({ title: "Choose Filter" });
    // what if we change the prop name or don't pass anything relevant?
  });

//Anti-Pattern Example: custom sleep code
test("movie title appears", async () => {
    // element is initially not present...
  
    // custom wait logic (caution: simplistic, no timeout)
    const interval = setInterval(() => {
      const found = getByText("the lion king");
      if (found) {
        clearInterval(interval);
        expect(getByText("the lion king")).toBeInTheDocument();
      }
    }, 100);
  
    // wait for appearance and return the element
    const movie = await waitForElement(() => getByText("the lion king"));
  });

///////////////////////////////////////Section 4️⃣: Measuring Test Effectiveness//////////////////////////////
//nti-Pattern Example: 100% coverage, 0% testing
function addNewOrder(newOrder) {
    logger.log(`Adding new order ${newOrder}`);
    DB.save(newOrder);
    Mailer.sendMail(newOrder.assignee, `A new order was places ${newOrder}`);
  
    return { approved: true };
  }
  
  it("Test addNewOrder, don't use such test names", () => {
    addNewOrder({ assignee: "John@mailer.com", price: 120 });
  }); //Triggers 100% code coverage, but it doesn't check anything

// Anti-Pattern Example: A test case full of errors, luckily all are caught by Linters
describe("Too short description", () => {
    const userToken = userService.getDefaultToken() // *error:no-setup-in-describe, use hooks (sparingly) instead
    it("Some description", () => {});//* error: valid-test-description. Must include the word "Should" + at least 5 words
  });
  
  it.skip("Test name", () => {// *error:no-skipped-tests, error:error:no-global-tests. Put tests only under describe or suite
    expect("somevalue"); // error:no-assert
  });
  
  it("Test name", () => {*//error:no-identical-title. Assign unique titles to tests
  });

  
