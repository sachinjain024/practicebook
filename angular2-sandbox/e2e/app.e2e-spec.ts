import { Angular2SandboxPage } from './app.po';

describe('angular2-sandbox App', function() {
  let page: Angular2SandboxPage;

  beforeEach(() => {
    page = new Angular2SandboxPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
