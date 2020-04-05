CREATE OR REPLACE VIEW payment_view AS (
	SELECT
		ROW_NUMBER () OVER (ORDER BY p.id),
		p.id AS payment_id,
		s.name AS student_name,
		c.name AS course_name,
		p.month,
		p.year,
		p.expiration_date,
		p.pay_date,
		c.price AS payment_value,
		p.amount_paid,
		p.payment_status
		FROM payment p
		LEFT JOIN enrollment e on e.id = p.enrollment_id
		LEFT JOIN course c on c.id = e.course_id
		LEFT JOIN student s on s.id = e.student_id
		-- WHERE p.month = (SELECT EXTRACT(MONTH FROM now()))
		-- AND p.year = (SELECT EXTRACT(YEAR FROM now()))
);
