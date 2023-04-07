const mongoose = require("mongoose");

const movieDB = "movieDBnew";

mongoose
  .connect(`mongodb://localhost/${movieDB}`, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => {
    console.log(`You are connected to the database called ${movieDB}`);
  })
  .catch((err) => {
    console.log(
      `You had a problem connecting the ${dbName}. Here is your error:`,
      err
    );
  });
