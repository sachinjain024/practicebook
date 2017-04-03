import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-another',
  template: `
    <p>
      Component with inline styles and templates
    </p>
  `,
  styles: [
    `
    p {
      color: red;
    }
    `
  ]
})
export class AnotherComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
