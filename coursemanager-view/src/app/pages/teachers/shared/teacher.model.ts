import { BaseResourceModel } from 'src/app/shared/models/base-resource.model';

export class Teacher extends BaseResourceModel {
  constructor(
    public name?: string,
    public email?: string,
    public phone?: string,
  ) {
    super();
  }

  static fromJson(jsonData: any): Teacher {
    return Object.assign(new Teacher(), jsonData);
  }
}
