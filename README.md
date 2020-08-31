1.	myRetail RESTful service

Build the application: mvn clean install
Build the docker: sudo docker build -t restfulservice
Run the docker: sudo docker run restfulservice

Implemented REST Endpoints:

Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store.
Method: PUT
URL: http://localhost:8080/products/12954218
Payload:
{
  "id": 12954218,
  "name": "The Big Lebowski (Blu-ray) (Widescreen)",
  "current_price": {
    "value": 13.49,
    "currency_code": "USD"
  }
}


Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. 
Method: GET
URL: http://localhost:8080/products/12954218


Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail)
Method: GET 
URL: http://localhost:8080/productName/123

