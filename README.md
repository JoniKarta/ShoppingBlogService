# ShoppingBlogService

## Description
Shopping Blog Microservice.<br>
This Microservice built in Java using SpringBoot framework, with Gradle build tools.



## Usage
Product Microservice API:
<table>
    <th>Method</th>
    <th>Route</th>
    <th>Usage</th>
		<tr>
			<td><b>POST</b></td>
			<td> /blog</td>
			<td>An action that receives a user's post about a product and saves it in the database.
				Users can post posts without a quantity limit and that each post pertains to a specific product.
				This action returns blog.</td>
		</tr>
		<tr>
			<td><b>GET</b></td>
			<td> /blog/byUser/{email}?sortBy={sortArrt}&sortOrder={order} </td>
			<td>An action that returns sorted array with all posts posted by a specific user.</td>
		</tr>
		<tr>
			<td><b><b>GET</b></b></td>
			<td>/blog/byUser/{email}?filterType=byLanguage&filterValue={language}&sortBy={sortArrt}&sortOrder={order}</td>
			<td>An action that returns sorted array of all posts posted by a specific user, written in the language defined in the URL.</td>
		</tr>
		<tr>
			<td><b>GET</b></td>
			<td>/blog/byUser/{email}?filterType=byCreation&filterValue={timeEnum}&sortBy={sortArrt}&sortOrder={order}</td>
			<td>An action that returns a sorted array of all posts posted by a specific user, posted at a specific time.<br>
				timeEnum can have one of the following values:<br>
				lastDay - will return posts published in the last 24 hours.<br>
				lastWeek - will return posts published in the last week.<br>
				lastMonth - will return posts published in the last 30 days.</td>
		</tr>
		<tr>
			<td><b>GET</b></td>
			<td>/blog/byUser/{email}?filterType=byProduct&filterValue={productId}&sortBy={sortArrt}&sortOrder={order} </td>
			<td>An action that returns a sorted array of all posts posted by a specific user on a specific product, whose identifier is defined in the URL.</td>
		</tr>
		<tr>
			<td><b>GET</b></td>
			<td> /blog/byProduct/{productId}?sortBy={sortArrt}&sortOrder={order</td>
			<td>An action that returns all the posts on a specific product, that returns a sorted array.</td>
		</tr>
		<tr>
			<td><b>GET</b></td>
			<td>/blog/byProduct/{productId}?filterType=byLanguage&filterValue={language}&sortBy={sortArrt}&sortOrder={order} </td>
			<td>An action that returns a sorted array of all posts on a specific product, written in the language defined in the URL.</td>
		</tr>
    <tr>
			<td><b>GET</b></td>
			<td> /blog/byProduct/{productId}?filterType=byCreation&filterValue={timeEnum}&sortBy={sortArrt}&sortOrder={order}</td>
			<td>An action that returns a sorted array of all posts on a specific product, published at a particular date.</td>
		</tr>   
    <tr>
			<td><b>GET</b></td>
			<td>/blog?filterType=byCreation&filterValue={timeEnum}&sortBy={sortArrt}&sortOrder={order}</td>
			<td>An action that returns a sorted array of all posts posted at a specific time.</td>
		</tr>
	  <tr>
			<td><b>GET</b></td>
			<td>/blog?filterType=byCount&filterValue={postsCount}/td>
			<td>An action that returns a sorted array of a certain number of recent posts posted on the service. The maximum number of posts that the service needs to 				return will be set in the postsCount variable.</td>
		</tr>
    <tr>
			<td><b>DELETE</b></td>
			<td>/blog</td>
			<td>An action that deletes all product posts only for testing.</td>
		</tr>

</table>


## Blog posts JSON examples

```json
{
  "user":{
    "email":"customer11@shop.ping"
  }, 
  "product":{
    "id":"p12x"
  },  
  "postingTimestamp":"2020-12-10T04:12:39.053+0000", 
  "language":"en", 
  "postContent":{
    "text":"I really like this product"
  }
}


```
```json
{
  "user":{
    "email":"customer98@shop.ping"
  }, 
  "product":{
    "id":"a32f"
  }, 
  "postingTimestamp":"2020-12-10T04:27:01.312+0000", 
  "language":"en", 
  "postContent":{
    "details":"the product installation is difficult", 
    "reference":"https://www.amazonas.corp/pid=a32f"
  }
}


```
```json

    {
  "user":{
    "email":"customerNumber1@shop.ping"
  }, 
  "product":{
    "id":"38996"
  },  
  "postingTimestamp":"2020-12-10T04:31:44.739+0000", 
  "language":"en", 
  "postContent":{
    "image":"http://image.im/product38996.jpg", 
    "message":"This product changed my life!", 
    "details":{
      "line1":"The fire consumed my apartment building",
      "line2":"I had to move to a shelter"
    }, 
    "references":[
      "https://newscase.org/firebrokeduetomulfunctioninproduct", 
      "http://www.cnn.com", 
      "http://demoservice.de.mo/story?stodyId=985645211596037"
    ]
  }
}
    
```


