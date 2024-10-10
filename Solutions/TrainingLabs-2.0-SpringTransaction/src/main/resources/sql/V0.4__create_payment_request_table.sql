CREATE TABLE IF NOT EXISTS public.payment_request
(
    id integer NOT NULL,
    account_no integer NOT NULL,
    ifsc_code character varying(50) NOT NULL,
    amount integer NOT NULL,
    payment_type character varying(50) NOT NULL,
    status character varying(50) NOT NULL,
    created_by character varying(100),
    created_at date,
    CONSTRAINT payment_request_pkey PRIMARY KEY (id)
)