import { BaseResourceModel } from 'src/app/shared/models/base-resource.model';
import { Teacher } from '../../teachers/shared/teacher.model';

export class Course extends BaseResourceModel {
  constructor(
    public name?: string,
    public description?: string,
    public price?: number,
    public teacher?: Teacher,
  ) {
    super();
  }

  static fromJson(jsonData: any): Course {
    return Object.assign(new Course(), jsonData);
  }
}
