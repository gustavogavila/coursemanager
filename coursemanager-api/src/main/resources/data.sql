INSERT INTO public.teacher(
	id, email, name, phone)
	VALUES (nextval('teacher_id_seq'), 'ana@email.com', 'Ana Maria', '85988887777'),
	(nextval('teacher_id_seq'), 'bruno@email.com', 'Bruno Braga', '85988887777'),
	(nextval('teacher_id_seq'), 'camila@email.com', 'Camila Sena', '85988887777');

INSERT INTO public.course(
	id, description, name, price, teacher_id)
	VALUES (nextval('course_id_seq'), 'Programa Geral', 'PG', 20.00, 1),
	(nextval('course_id_seq'), 'Programa Fundamental', 'PF', 120.00, 2),
	(nextval('course_id_seq'), 'Programa de Formação de Professores', 'PFP', 150.00, 1);

INSERT INTO public.student(
	id, email, name, phone)
	VALUES (nextval('student_id_seq'), 'angela@email.com', 'Ângela Costa', '85988887777'),
	(nextval('student_id_seq'), 'bernardo@email.com', 'Bernardo Nunes', '85988887777'),
	(nextval('student_id_seq'), 'cibele@email.com', 'Cibele Medeiros', '85988887777')





