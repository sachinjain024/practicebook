# using classes: 95 lines of js
# using extend : 50 lines of js

#class Item extends Backbone.Model
Item = Backbone.Model.extend({})

#class Items extends Backbone.Collection
Items = Backbone.Collection.extend
  model: Item
  url: '/items'

#class ItemView extends Backbone.View
ItemView = Backbone.View.extend
  template: _.template '<h2><%= name %></h2>'
  render: ->
    @el.innerHTML = @template @model.toJSON()
    @

#class ItemsView extends Backbone.View
ItemsView = Backbone.View.extend
  template: _.template '<h1><%= count %> Items</h1>'
  render: ->
    @el.innerHTML = @template count: @collection.length
    #@el.appendChild new ItemView(model: model).render().el for model in @collection.models
    #@collection.forEach (model) => @el.appendChild new ItemView(model: model).render().el
    @collection.forEach ((model) -> @el.appendChild new ItemView(model: model).render().el), @
    @

items = new Items [{ name: "Item 1" }, { name: "Item 2" }]
itemsView = new ItemsView collection: items

$("#main").append itemsView.render().el
