Notification Module – Backend Documentation
Overview

The Notification Module is a backend component of the Smart Digital Wallet and Expense Management Application. It is responsible for generating, storing, and delivering notifications to users based on system activities such as expense updates, budget limits, and scheduled reminders. The module is implemented using Spring Boot and integrates with SendGrid to send email notifications in real time.

This module follows a layered architecture approach, ensuring separation of concerns between controller, service, repository, and scheduling components. It is designed to be scalable and easily integrable with other modules such as Expense Management, Budget Management, and User Management.

Features

The module supports creation and storage of notifications in a database, retrieval of user-specific notifications, and updating notification status such as marking them as read. In addition to database persistence, it also sends email alerts using SendGrid whenever a notification is generated.

The system also includes scheduled notifications, which are automatically triggered at predefined times using Spring Scheduler. This allows implementation of features such as daily reminders and bill due alerts without manual intervention.

Architecture

The module is structured into multiple layers. The controller layer exposes REST APIs to interact with notifications. The service layer contains the core business logic for creating and managing notifications. The repository layer handles database operations using Spring Data JPA. The scheduler component is responsible for triggering automated notifications based on time-based events.

The EmailService integrates with SendGrid and is used by the NotificationService to send emails whenever a notification is created. All components work together to ensure that notifications are both persisted and delivered effectively.

Data Model

The Notification entity represents the structure of a notification stored in the database. It contains fields such as userId, email, title, message, type, read status, and creation timestamp. This design allows tracking of all notifications associated with a user and supports features like filtering and sorting.

API Endpoints

The module provides REST endpoints to retrieve notifications for a specific user and to update the read status of a notification. These endpoints can be consumed by the frontend application to display notifications and manage their state.

Email Integration

SendGrid is used as the email service provider for sending notifications. The API key and sender email are configured in the application properties file. Whenever a notification is created, the EmailService sends an email to the user's registered email address with the notification details.

Scheduling

The module uses Spring Boot’s scheduling capability to automate notifications. Scheduled tasks run at configured intervals and trigger notifications such as reminders or alerts. This ensures that users receive timely updates without requiring manual actions.

Workflow

When an event occurs in the system, such as adding an expense or exceeding a budget, the corresponding service calls the NotificationService. The NotificationService creates a notification record in the database and then invokes the EmailService to send an email. For scheduled events, the scheduler directly triggers the NotificationService at specified times.

Configuration

The module requires configuration of the SendGrid API key and sender email in the application properties file. It also depends on proper database configuration for storing notification data. Scheduling must be enabled in the main application class to allow automated tasks to run.

Conclusion

The Notification Module provides a complete backend solution for managing and delivering notifications within the application. It ensures that users stay informed about important events through both in-app notifications and email alerts. The use of Spring Boot, SendGrid, and scheduling makes the module robust, extensible, and suitable for real-world applications.
