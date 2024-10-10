CREATE TABLE IF NOT EXISTS public.audit_master
(
    id integer NOT NULL,
    event character varying(50) NOT NULL,
    booking_id integer NOT NULL,
    payment_id character varying(50) NOT NULL,
    status character varying(50) NOT NULL,
    created_by character varying(100),
    created_at date,
    CONSTRAINT audit_pkey PRIMARY KEY (id)
)