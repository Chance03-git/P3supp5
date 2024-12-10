const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

// Connect to MongoDB (replace <your_mongo_uri> with your actual connection string)
mongoose.connect('<your_mongo_uri>', { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.error('Could not connect to MongoDB...', err));

// Define a schema and model for storing content
const contentSchema = new mongoose.Schema({
    content: String,
    createdAt: { type: Date, default: Date.now }
});

const Content = mongoose.model('Content', contentSchema);

const app = express();
app.use(bodyParser.json());

app.post('/', async (req, res) => {
    const { content } = req.body;

    // Check if 'content' field is provided
    if (!content) {
        return res.status(400).json({ error: 'Content field is required' });
    }

    // Create a new document and save it to MongoDB
    const newContent = new Content({ content });
    await newContent.save();

    // Respond with the content
    res.status(200).json({ message: content });
});

app.listen(3000, () => {
    console.log('Server is running on port 3000');
});
