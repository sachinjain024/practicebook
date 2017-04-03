Udemy - Complete guide to Angular 2
-----------------------------------

## Angular Cli
- https://cli.angular.io/

### Setup a new project
- npm install -g angular-cli
- ng new my-app
- cd my-app
- ng serve

### Generating a component
    ng generate component <component_name>
    ng g c <component_name>

#### Flags

    --flat: Do not create files in new directory
    --inline-template or -it
    --inline-style or -is

## Module
- A module is something which exports some code
- We import code from other modules

## Components
- @Component() decorator takes a JavaScript object as an argument and uses this argument to add some metadata (in the background) to this class.
- Similar to decorator pattern (Pizza factory)
- Backticks allows us to write multiline strings
- Strings can be used inline in template and styles as keys instead of templateUrl and stylesUrl

## Project Structure and Bootstraping
- main.ts is the code which is executed first
- We specify our root/top-level component in main.ts
- index.html is rendered as SPA

## Views
- Angular2 has view encapsulation i.e. any styles are encapsulated within a view and it does not affect any element outside it.
- Does it by adding random atributes to each DOM element and modifies the styles and adds the attribute and copy the styles in head

## Directives
- ng-content directive contains the markup passed by parent component to child component. Child component overrides the el with its own template so ng-content can be used to refer to any markup passed from outside.

## Bindings

### String Interpolation
- {{ ... }} : ... must resolve to a string

### Property Binding
- [property] = "expressions to result into property value"

e.g.
<input type="text" value="{{someExp}}">
<input type="text" [value]="someExp"> 

Both the examples are correct and anyone can be used.


## Links
- https://github.com/angular/angular-cli#updating-angular-cli