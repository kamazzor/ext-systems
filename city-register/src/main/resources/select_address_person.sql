--Check if person are registered in GRN and what type of registration (temporal or not)
SELECT temporal  FROM cr_address_person ap
INNER JOIN cr_person p ON p.person_id = ap.person_id
INNER JOIN cr_address a ON a.address_id = ap.address_id
WHERE
CURRENT_DATE >= ap.start_date AND (CURRENT_DATE <= ap.end_date OR ap.end_date is null)
UPPER(p.sur_name) = UPPER(?) and UPPER(p.given_name) = UPPER(?) and UPPER(patronymic) = UPPER(?)
  and p.date_of_birth = ? and a.street_code = ?
  and UPPER(a.building) = UPPER(?) and UPPER(a.extension) = UPPER(?) and UPPER(a.apartment) = UPPER(?)

-- SELECT temporal  FROM cr_address_person ap
-- INNER JOIN cr_person p ON p.person_id = ap.person_id
-- INNER JOIN cr_address a ON a.address_id = ap.address_id
-- WHERE
-- upper(p.sur_name) = upper('васильев') and upper(p.given_name) = upper('Павел')
--   and upper(patronymic) = upper('Николаевич')
--   and p.date_of_birth = '1995-03-18'
--   and a.street_code = 1 and upper(a.building) = upper('10')
--   and upper(a.extension) = upper('2') and upper(a.apartment) = upper('121')