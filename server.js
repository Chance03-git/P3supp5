const express = require('express');
const fs = require('fs');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());

app.post('/', (req, res) => {
    const { content } = req.body;

    if (!content) {
        return res.status(400).send('Content field is required');
    }

    // Write content to file
    fs.writeFile('content.txt', content, (err) => {
        if (err) {
            return res.status(500).send('Error writing file');
        }

        // Save the entire JSON body to a mock "database"
        fs.writeFile('database.json', JSON.stringify(req.body, null, 2), (err) => {
            if (err) {
                return res.status(500).send('Error saving to database');
            }

            res.status(200).send(content);
        });
    });
});

app.listen(3000, () => {
    console.log('Server is running on port 3000');
});
