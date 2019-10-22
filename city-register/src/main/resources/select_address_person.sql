--Check if person are registered in GRN and what type of registration (temporal or not)
SELECT temporal  FROM cr_address_person ap
INNER JOIN cr_person p ON p.person_id = ap.person_id
INNER JOIN cr_address a ON a.address_id = ap.address_id
WHERE
UPPER(p.sur_name) = UPPER(?) and UPPER(p.given_name) = UPPER(?) and UPPER(patronymic) = UPPER(?)
  and p.date_of_birth = ? and a.street_code = ?
  and UPPER(a.building) = UPPER(?) and UPPER(a.extension) = UPPER(?) and UPPER(a.apartment) = UPPER(?)