# Orders-Api
> This Spring Boot API processes customer orders asynchronously using RabbitMQ and stores them reliably in MongoDB.

#### Technologies ####

+ Java 17
+ Spring Boot 3.x
+ Spring Data MongoDB
+ Spring AMQP (RabbitMQ)
+ MongoDB 5.0
+ RabbitMQ 3.13 management
+ Maven 3.x
+ Docker and Docker Compose

> Note: This API uses JDK Eclipse Temurin 17.0.15

### How to Test This API ###


1. Clone the repository:
    ```
    git clone https://github.com/Maik-Furtado/Orders-Api.git
    cd Orders-Api
2. Start the application with Docker Compose:
   ```
   docker compose up -d --build
3.Access RabbitMQ Management:
- Open http://localhost:15672
- Log in with:

  - Username: guest
  - Password: guest

- Go to the Queues tab and select the orders queue (e.g., orders-queue).
- Click the queue name, scroll to the Publish Message section, and send the following JSON payload:
``` 
{
  "orderId": 1001,
  "customerId": 1,
  "items": [
    {
      "product": "Pen",
      "quantity": 100,
      "price": 1.11
    },
    {
      "product": "Smartphone",
      "quantity": 12,
      "price": 1.67
    }
  ]
} 
```
4. Check the order via REST API:

Use your preferred API client (like Postman, Insomnia, Hoppscotch, etc.) and make the following request:
 ``` 
GET http://localhost:8080/customers/1/orders
```
This will return the list of orders for customer 1.
________________________________________________

Thanks for stopping by!

✍️ *Maik Gabriel Anton Furtado*  
| 📧 **Email:** maikgafurtado@gmail.com  
| 🔗 **LinkedIn:** [linkedin.com/in/maikgafurtado](https://www.linkedin.com/in/maikgafurtado/)  
| 💻 **GitHub:** [github.com/Maik-Furtado](https://github.com/Maik-Furtado)
