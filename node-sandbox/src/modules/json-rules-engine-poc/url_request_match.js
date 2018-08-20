/**
 * Created by sachinjain on 20/08/18.
 */
const jsonRulesEngine = require('json-rules-engine');
const Engine = jsonRulesEngine.Engine;

/**
 * Setup a new engine
 * Operators: https://github.com/CacheControl/json-rules-engine/blob/master/src/engine-default-operators.js
 */
let engine = new Engine();

engine.addRule({
  conditions: {
    any: [
      {
        all: [
          {
            fact: 'Url',
            operator: 'contains',
            value: 'linkedin.com'
          },
          {
            fact: 'Path',
            operator: 'doesNotContain',
            value: 'feed'
          }
        ]
      },
      {
        all: [
          {
            fact: 'Url',
            operator: 'contains',
            value: 'stackoverflow.com'
          },
          {
            fact: 'Url',
            operator: 'doesNotContain',
            value: 'users'
          }
        ]
      }
    ]
  },
  event: {  // define the event to fire when the conditions evaluate truthy
    type: 'ConditionsMatched'
  }
});

/**
 * Define facts the engine will use to evaluate the conditions above.
 * Facts may also be loaded asynchronously at runtime; see the advanced example below
 */
let factsGroup = [
  {
    Url: 'https://www.linkedin.com/in/sachin-jain-20b20731/',
    Path: '/in/sachin-jain-20b20731/'
  },
  {
    Url: 'https://stackoverflow.com/users/816213/sachinjain024',
    Path: '/users/816213/sachinjain024'
  },
  {
    Url: 'https://stackoverflow.com/questions/22931720/is-there-a-way-to-modify-an-http-request-in-chrome-or-firefox/45934508',
    Path: '/questions/22931720/is-there-a-way-to-modify-an-http-request-in-chrome-or-firefox/45934508'
  }
];

// Run the engine to evaluate
factsGroup.forEach((factGroup) => {
  console.log('Running engine for factGroup with Url=' + factGroup.Url);

  engine
    .run(factGroup)
    .then(events => {
      events.map(event => {
        console.log(event.type + 'for Url=' + factGroup.Url);
      })
    });
});
