var RQ = RQ || {};

RQ.VERSION = 1;

// Url which gets opened when User clicks on browserAction (requestly icon) in toolbar
RQ.WEB_URL = 'http://web.requestly.in';

RQ.WEB_URL_PATTERN = '*://web.requestly.in/*';

RQ.BLACK_LIST_DOMAINS = [
  'requestly.in'
];

RQ.LIMITS = {
  NUMBER_SHARED_LISTS: 10
};

RQ.RULE_TYPES = {
  REDIRECT: 'Redirect',
  CANCEL: 'Cancel',
  REPLACE: 'Replace',
  HEADERS: 'Headers'
};

RQ.RULE_STATUS = {
  ACTIVE: 'Active',
  INACTIVE: 'Inactive'
};

RQ.RULE_KEYS = {
  URL: 'Url',
  HEADER: 'Header'
};

RQ.RULE_OPERATORS = {
  EQUALS: 'Equals',
  CONTAINS: 'Contains',
  MATCHES: 'Matches'
};

RQ.MODIFICATION_TYPES = {
  ADD: 'Add',
  REMOVE: 'Remove',
  MODIFY: 'Modify'
};

RQ.HEADERS_TARGET = {
  REQUEST: 'Request',
  RESPONSE: 'Response'
};

RQ.RESPONSE_CODES = {
  NOT_FOUND: 404
};

RQ.STORAGE_KEYS = {
  REQUESTLY_SETTINGS: 'rq_settings'
};

RQ.MESSAGES = {
  DELETE_RULE: 'Are you sure you want to delete the rule ?',
  SIGN_IN_TO_VIEW_SHARED_LISTS: 'Please login with Google to view your Shared Lists.',
  ERROR_AUTHENTICATION: 'Received some error in authentication. Please try again later!!',
  SHARED_LISTS_LIMIT_REACHED: 'You can not create more than ' + RQ.LIMITS.NUMBER_SHARED_LISTS + ' shared lists'
};

RQ.RESOURCES = {
  EXTENSION_ICON: '/resources/images/38x38.png',
  EXTENSION_ICON_GREYSCALE: '/resources/images/38x38_greyscale.png'
};

RQ.GA_EVENTS = {
  CATEGORIES: {
    RULES: 'rules',
    USER: 'user',
    SHARED_LIST: 'shared list'
  },
  ACTIONS: {
    MODIFIED: 'modified',
    CREATED: 'created',
    DELETED: 'deleted',
    ACTIVATED: 'activated',
    DEACTIVATED: 'deactivated',
    IMPORTED: 'imported',
    EXPORTED: 'exported',
    LIMIT_REACHED: 'limit reached',
    AUTHENTICATED: 'authenticated',
    VIEWED: 'viewed'
  }
};

RQ.USER = {
  AUTHORIZED: 'authorized-user',
  UNAUTHORIZED: 'unauthorized-user'
};

RQ.FIREBASE_NODES = {
  USERS: 'users',
  PUBLIC: 'public',
  SHARED_LISTS: 'sharedLists'
};

RQ.getFirebaseRef = function() {
  if (!RQ.firebaseRef) {
    RQ.firebaseRef = new Firebase('https://requestly.firebaseio.com');
  }

  return RQ.firebaseRef;
};

RQ.htmlEncode = function(value){
  return $('<div/>').text(value).html();
};

RQ.getSharedURL = function(shareId) {
  return RQ.WEB_URL + '#sharedList/' + shareId;
};

