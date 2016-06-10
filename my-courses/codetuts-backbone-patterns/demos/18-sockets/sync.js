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
