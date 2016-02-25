    var fs = require('fs'); //Import fs module
    var preeti = require('./preeti');
    var readFile = fs.createReadStream('Constitution_of_Nepal-Final.txt'); //Create a 'readable' file stream for file "read.txt"
    var writeFile = fs.createWriteStream('Constitution_of_Nepal-Final-Unicode-Node.txt'); //Create a 'writable' file stream
    var lineReader = require('readline').createInterface({
	  input: require('fs').createReadStream('Constitution_of_Nepal-Final.txt')
	});
    // readFile.on('data', function(chunk) { //Latch on the 'data' event to read data chunk by chunk
    //     writeFile.write(preeti.convert_to_unicode(chunk)); //Write the data chunk by chunk to writable stream
    // });
    lineReader.on('line', function (line) {
    	console.log("Successfully received data " + line);
	  writeFile.write(preeti.convert_to_unicode(line) + '\r\n'); //Write the data chunk by chunk to writable stream
	});
    lineReader.on('end', function() { //Display a message once everything is read
        console.log("Successfully received data");
    });