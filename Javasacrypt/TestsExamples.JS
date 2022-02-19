//////////////////////////////////////////////Doing It Right Section////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////Section 1: The Test Anatomy//////////////////////////////////////////////////////////////

//Doing It Right Example: A test structured with the AAA pattern
describe("Customer classifier", () => {
  test("When customer spent more than 500$, should be classified as premium", () => {
    //Arrange
    const customerToClassify = { spent: 505, joined: new Date(), id: 1 };
    const DBStub = sinon.stub(dataAccess, "getCustomer").reply({ id: 1, classification: "regular" });

    //Act
    const receivedClassification = customerClassifier.classifyCustomer(customerToClassify);

    //Assert
    expect(receivedClassification).toMatch("premium");
  });
});

//Doing It Right Example: Skimming through the following declarative test is a breeze
it("When asking for an admin, ensure only ordered admins in results", () => {
    //assuming we've added here two admins
    const allAdmins = getUsers({ adminOnly: true });
  
    expect(allAdmins)
      .to.include.ordered.members(["admin1", "admin2"])
      .but.not.include.ordered.members(["user1"]);
  });

  //Doing It Right Example: spies are focused on testing the requirements but as a side-effect are unavoidably touching to the internals
  it("When a valid product is about to be deleted, ensure an email is sent", async () => {
    //Assume we already added here a product
    const spy = sinon.spy(Emailer.prototype, "sendEmail");
    new ProductService().deletePrice(theProductWeJustAdded);
    //hmmm OK: we deal with internals? Yes, but as a side effect of testing the requirements (sending an email)
    expect(spy.calledOnce).to.be.true;
  });

  //Doing It Right Example: Randomizing realistic input
  it("Better: When adding new valid product, get successful confirmation", async () => {
    const addProductResult = addProduct(faker.commerce.productName(), faker.random.number());
    //Generated random input: {'Sleek Cotton Computer',  85481}
    expect(addProductResult).to.be.true;
    //Test failed, the random input triggered some path we never planned for.
    //We discovered a bug early!
  });

  import fc from "fast-check";

//Doing It Right Example: Testing many input permutations with “fast-check”
describe("Product service", () => {
  describe("Adding new", () => {
    //this will run 100 times with different random properties
    it("Add new product with random yet valid properties, always successful", () =>
      fc.assert(
        fc.property(fc.integer(), fc.string(), (id, name) => {
          expect(addNewProduct(id, name).status).toEqual("approved");
        })
      ));
  });
});

//Doing It Right Example: Expectations are visible and focused
it("When visiting TestJavaScript.com home page, a menu is displayed", () => {
    //Arrange
  
    //Act
    const receivedPage = renderer
      .create(<DisplayPage page="http://www.testjavascript.com"> Test JavaScript </DisplayPage>)
      .toJSON();
  
    //Assert
  
    const menu = receivedPage.content.menu;
    expect(menu).toMatchInlineSnapshot(`
  <ul>
  <li>Home</li>
  <li> About </li>
  <li> Contact </li>
  </ul>
  `);
  });

  //Doing It Right Example: We can stay within the test, each test acts on its own set of data
  it("When updating site name, get successful confirmation", async () => {
    //test is adding a fresh new records and acting on the records only
    const siteUnderTest = await SiteService.addSite({
      name: "siteForUpdateTest"
    });
  
    const updateNameResult = await SiteService.changeName(siteUnderTest, "newName");
  
    expect(updateNameResult).to.be(true);
  });

  // Doing It Right Example: A human-readable expectation that could be understood easily, maybe even by QA or technical PM
  it("When no product name, it throws error 400", async () => {
    await expect(addNewProduct({}))
      .to.eventually.throw(AppError)
      .with.property("code", "InvalidInput");
  });

  // Doing It Right Example: Tagging tests as ‘#cold-test’ allows the test runner to execute only fast tests
  // (Cold===quick tests that are doing no IO and can be executed frequently even as the developer is typing)
  //this test is fast (no DB) and we're tagging it correspondigly
//now the user/CI can run it frequently
describe("Order service", function() {
    describe("Add new order #cold-test #sanity", function() {
      test("Scenario - no currency was supplied. Expectation - Use the default currency #sanity", function() {
        //code logic here
      });
    });
  });

  //Doing It Right Example: Structuring suite with the name of unit under test and scenarios will lead to the convenient report that is shown below
  // Unit under test
describe("Transfer service", () => {
    //Scenario
    describe("When no credit", () => {
      //Expectation
      test("Then the response status should decline", () => {});
  
      //Expectation
      test("Then it should send email to admin", () => {});
    });
  });



  ////////////////////////////////////////////Section 2️⃣: Backend Testing///////////////////////////////////////////////////////////



//Doing It Right Example: Testing middleware in isolation without issuing network calls and waking-up the entire Express machine
//the middleware we want to test
const unitUnderTest = require("./middleware");
const httpMocks = require("node-mocks-http");
//Jest syntax, equivelant to describe() & it() in Mocha
test("A request without authentication header, should return http status 403", () => {
  const request = httpMocks.createRequest({
    method: "GET",
    url: "/user/42",
    headers: {
      authentication: ""
    }
  });
  const response = httpMocks.createResponse();
  unitUnderTest(request, response);
  expect(response.statusCode).toBe(403);
});

//Doing It Right Example: We can stay within the test, each test acts on its own set of data
it("When updating site name, get successful confirmation", async () => {
    //test is adding a fresh new records and acting on the records only
    const siteUnderTest = await SiteService.addSite({
      name: "siteForUpdateTest"
    });
    const updateNameResult = await SiteService.changeName(siteUnderTest, "newName");
    expect(updateNameResult).to.be(true);
  });


///////////////////////////////////////////Section 3️⃣: Frontend Testing//////////////////////////////////////////////


//Doing It Right Example: Separating out the UI details
test("When users-list is flagged to show only VIP, should display only VIP members", () => {
    // Arrange
    const allUsers = [{ id: 1, name: "Yoni Goldberg", vip: false }, { id: 2, name: "John Doe", vip: true }];
  
    // Act
    const { getAllByTestId } = render(<UsersList users={allUsers} showOnlyVIP={true} />);
  
    // Assert - Extract the data from the UI first
    const allRenderedUsers = getAllByTestId("user").map(uiElement => uiElement.textContent);
    const allRealVIPUsers = allUsers.filter(user => user.vip).map(user => user.name);
    expect(allRenderedUsers).toEqual(allRealVIPUsers); //compare data with data, no UI here
  });

 //Doing It Right Example: Querying an element using a dedicated attribute for testing
 // the markup code (part of React component)
<h3>
  <Badge pill className="fixed_badge" variant="dark">
    <span data-test-id="errorsLabel">{value}</span>
  //note the attribute data-test-id
  </Badge>
</h3>

// this example is using react-testing-library
test("Whenever no data is passed to metric, show 0 as default", () => {
    // Arrange
    const metricValue = undefined;
  
    // Act
    const { getByTestId } = render(<dashboardMetric value={undefined} />);
  
    expect(getByTestId("errorsLabel").text()).toBe("0");
  });

  //Doing It Right Example: Working realistically with a fully rendered component
  class Calendar extends React.Component {
    static defaultProps = { showFilters: false };
  
    render() {
      return (
        <div>
          A filters panel with a button to hide/show filters
          <FiltersPanel showFilter={showFilters} title="Choose Filters" />
        </div>
      );
    }
  }
  
  //Examples use React & Enzyme
  test("Realistic approach: When clicked to show filters, filters are displayed", () => {
    // Arrange
    const wrapper = mount(<Calendar showFilters={false} />);
  
    // Act
    wrapper.find("button").simulate("click");
  
    // Assert
    expect(wrapper.text().includes("Choose Filter"));
    // This is how the user will approach this element: by text
  });

  //Doing It Right Example: E2E API that resolves only when the async operations is done (Cypress)
  // using Cypress
cy.get("#show-products").click(); // navigate
cy.wait("@products"); // wait for route to appear
// this line will get executed only when the route is ready

//Doing It Right Example: Testing library that waits for DOM elements
// @testing-library/dom
test("movie title appears", async () => {
    // element is initially not present...
  
    // wait for appearance
    await wait(() => {
      expect(getByText("the lion king")).toBeInTheDocument();
    });
  
    // wait for appearance and return the element
    const movie = await waitForElement(() => getByText("the lion king"));
  });

  //Doing It Right Example: Stubbing or intercepting API calls
  // unit under test
export default function ProductsList() {
    const [products, setProducts] = useState(false);
  
    const fetchProducts = async () => {
      const products = await axios.get("api/products");
      setProducts(products);
    };
  
    useEffect(() => {
      fetchProducts();
    }, []);
  
    return products ? <div>{products}</div> : <div data-test-id="no-products-message">No products</div>;
  }
  
  // test
  test("When no products exist, show the appropriate message", () => {
    // Arrange
    nock("api")
      .get(`/products`)
      .reply(404);
  
    // Act
    const { getByTestId } = render(<ProductsList />);
  
    // Assert
    expect(getByTestId("no-products-message")).toBeTruthy();
  });

  //Doing It Right Example: Logging-in before-all and not before-each
  let authenticationToken;

// happens before ALL tests run
before(() => {
  cy.request('POST', 'http://localhost:3000/login', {
    username: Cypress.env('username'),
    password: Cypress.env('password'),
  })
  .its('body')
  .then((responseFromLogin) => {
    authenticationToken = responseFromLogin.token;
  })
})

// happens before EACH test
beforeEach(setUser => () {
  cy.visit('/home', {
    onBeforeLoad (win) {
      win.localStorage.setItem('token', JSON.stringify(authenticationToken))
    },
  })
})

//Doing It Right Example: Smoke travelling across all pages
it("When doing smoke testing over all page, should load them all successfully", () => {
    // exemplified using Cypress but can be implemented easily
    // using any E2E suite
    cy.visit("https://mysite.com/home");
    cy.contains("Home");
    cy.contains("https://mysite.com/Login");
    cy.contains("Login");
    cy.contains("https://mysite.com/About");
    cy.contains("About");
  });


//Doing It Right Example: Using Applitools to get snapshot comparison and other advanced features
import * as todoPage from "../page-objects/todo-page";

describe("visual validation", () => {
  before(() => todoPage.navigate());
  beforeEach(() => cy.eyesOpen({ appName: "TAU TodoMVC" }));
  afterEach(() => cy.eyesClose());

  it("should look good", () => {
    cy.eyesCheckWindow("empty todo list");
    todoPage.addTodo("Clean room");
    todoPage.addTodo("Learn javascript");
    cy.eyesCheckWindow("two todos");
    todoPage.toggleTodo(0);
    cy.eyesCheckWindow("mark as completed");
  });
});




