import { CoursesAppPage } from './app.po';

describe('courses-app App', () => {
  let page: CoursesAppPage;

  beforeEach(() => {
    page = new CoursesAppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
