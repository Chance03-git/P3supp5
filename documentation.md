# Express Server

## Description
This is a simple Express server that exposes a POST endpoint. It takes a JSON payload with a `content` field, writes the content to a file, and saves the full JSON into a database.

## Installation

1. Clone the repository.
2. Run `npm install` to install the dependencies.
3. Run the server using `node server.js`.

## API Documentation

### POST `/`

- **Request**: JSON body with a `content` field.
  ```json
  {
    "content": "Hello, world!"
  }
