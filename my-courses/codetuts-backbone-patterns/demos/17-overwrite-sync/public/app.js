var methodMap = {
    'create': 'POST',
    'update': 'POST',
    'delete': 'GET',
    'read':   'GET'
};
var Person = Backbone.Model.extend({});

var People = Backbone.Collection.extend({
    model: Person,
    url: '/people',
    sync: function(method, model, options) {
        var type = methodMap[method];

        options || (options = {});

        var params = {type: type, dataType: 'json'};

        if (!options.url) {
            params.url = _.result(model, 'url') || urlError();
        }
        console.log(method);
        switch (method) {
            case 'create': params.url += '/new'; break;
            case 'update': params.url += '/update'; break;
            case 'delete': params.url += '/delete'; break;
        }

        if (!options.data && model && (method === 'create' || method === 'update')) {
            params.contentType = 'application/json';
            params.data = JSON.stringify(model);
        }

        if (Backbone.emulateJSON) {
            params.contentType = 'application/x-www-form-urlencoded';
            params.data = params.data ? {model: params.data} : {};
        }

        if (Backbone.emulateHTTP) {
            if (type === 'PUT' || type === 'DELETE') {
                if (Backbone.emulateJSON) params.data._method = type;
                params.type = 'POST';
                params.beforeSend = function(xhr) {
                    xhr.setRequestHeader('X-HTTP-Method-Override', type);
                };
            }
        }

        if (params.type !== 'GET' && !Backbone.emulateJSON) {
            params.processData = false;
        }

        var success = options.success;
        options.success = function(resp, status, xhr) {
            if (success) success(resp, status, xhr);
            model.trigger('sync', model, resp, options);
        };

        var error = options.error;
        options.error = function(xhr, status, thrown) {
            if (error) error(model, xhr, options);
            model.trigger('error', model, xhr, options);
        };

        return $.ajax(_.extend(params, options));
    }
});

Person.prototype.sync = People.prototype.sync;

var people = new People;

people.fetch();
