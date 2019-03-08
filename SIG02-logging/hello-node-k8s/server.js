const express = require("express");
const app = express();
const log4js = require('log4js');
const os = require('os');
const logger = log4js.getLogger();

logger.level = 'debug';

log4js.configure({
  appenders: {
    console: {
      type: 'console'
    },
    applog: { 
      type: 'file', 
      filename: 'applog.log' 
    },
    logstash: {
      host: "logstash.logging",
      port: 30994,
      type: '@log4js-node/logstash-http',
      fields: {             // Optional, will be added to the 'fields' object in logstash
        server: os.hostname()
      },
      layout: {
        type: "pattern",
        pattern: "%m"
      },
      category: "debugging"
    }
  },
  categories: {
    default: {
      appenders: ['console','applog'],
      level: 'info'
    },
    debugging: {
      appenders: ['logstash'],
      level: 'debug'
    }
  }
});

app.get('/hello/:name', (req, res) => {
  logger.debug(`GET /hello | Parameters: ${JSON.stringify(req.params)}`);
  logger.info(`Hello ${req.params['name']}.`);

  res.json([`Hello ${req.params['name']}`]);
});

listener = app.listen(8080, () => {
  console.log("Server running on port 8080");
  logger.info(`${os.hostname()}:${listener.address().port} | Started serving requests on port 8080`);
});