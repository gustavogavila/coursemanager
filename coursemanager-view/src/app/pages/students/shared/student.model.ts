import { BaseResourceModel } from 'src/app/shared/models/base-resource.model';

export class Student extends BaseResourceModel {

  constructor(
    public name?: string,
    public email?: string,
    public phone?: string,
  ) {
    super();
  }

  static fromJson(jsonData: any): Student {
    return Object.assign(new Student(), jsonData);
  }
}
