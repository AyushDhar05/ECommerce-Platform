# Ecommerce Website - Product Requirements Document(PRD) and High-Level Design(HLD)

## Table of Contents

1. [Functional Requirements](#functional-requirements)  
   1.1 [User Management](#user-management)  
   1.2 [Product Catalog](#product-catalog)  
   1.3 [Cart & Checkout](#cart--checkout)  
   1.4 [Order Management](#order-management)  
   1.5 [Payment](#payment)  
   1.6 [Authentication](#authentication)
2. [High-Level Design (HLD)](#high-level-design-hld)  
   2.1 [Architecture Components](#architecture-components)  
   2.2 [Microservices](#microservices)  
   2.3 [Database](#database)  
   2.4 [Message Broker (Kafka)](#message-broker-kafka)  
   2.5 [Caching (Redis)](#caching-redis)  
   2.6 [Search and Analytics (Elasticsearch)](#search-and-analytics-elasticsearch)
3. [Typical Flow](#typical-flow)

---

## Functional Requirements

### 1. User Management
- **Registration**: Allow users to register via email or social media profiles.
- **Login**: Secure user login with credentials.
- **Profile Management**: Enable users to view and edit their profiles.
- **Password Reset**: Allow password resets through secure email links.

### 2. Product Catalog
- **Browsing**: Users can browse products by category.
- **Product Details**: Product pages include images, descriptions, specifications, and more.
- **Search**: Provide search functionality with keyword-based queries.

### 3. Cart & Checkout
- **Add to Cart**: Users can add products to their cart.
- **Cart Review**: View selected items with price, quantity, and totals.
- **Checkout**: Seamless process to finalize purchases, including delivery details and payment options.

### 4. Order Management
- **Order Confirmation**: Confirm orders with details after purchase.
- **Order History**: Allow users to view past orders.
- **Order Tracking**: Provide delivery status tracking.

### 5. Payment
- **Multiple Payment Options**: Support credit/debit cards, online banking, and other methods.
- **Secure Transactions**: Ensure secure payment handling.
- **Payment Receipt**: Generate receipts for successful payments.

### 6. Authentication
- **Secure Authentication**: Protect user data during login and active sessions.
- **Session Management**: Allow users to stay logged in until they log out or after a specified duration.

---

## High-Level Design (HLD)

### Architecture Components
- **Load Balancers (LB)**: Distribute traffic across servers for high availability (e.g., AWS ELB).
- **API Gateway**: Entry point for routing requests, managing rate limits, and handling authentication (e.g., Kong).
- **Microservices**: Separate services for modular and scalable architecture.
- **Databases**: MySQL and MongoDB for structured and unstructured data.
- **Message Broker (Kafka)**: Enable asynchronous inter-service communication.
- **Caching (Redis)**: Boost response times for frequently accessed data.
- **Search & Analytics (Elasticsearch)**: Efficient product searches with advanced capabilities.

---

## Typical Flow

### Part 1: Product Search
1. User logs in and searches for a product.
2. Request passes through the Load Balancer to the API Gateway.
3. API Gateway routes the search request to the Product Catalog Service.
4. Product Catalog Service queries Elasticsearch for results.

### Part 2: Add to Cart
1. User adds a product to the cart.
2. Cart Service stores the item in MongoDB and produces a Kafka message.

### Part 3: Checkout
1. User checks out.
2. Order Management Service processes the order and sends a Kafka message.
3. Payment Service consumes the message to handle payment.

---
