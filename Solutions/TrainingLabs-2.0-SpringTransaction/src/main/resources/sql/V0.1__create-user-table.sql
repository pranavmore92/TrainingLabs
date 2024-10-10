CREATE TABLE IF NOT EXISTS public.user_master
(
    id integer NOT NULL,
    username character varying(100) NOT NULL,
    first_name character varying(150) NOT NULL,
    last_name character varying(150) NOT NULL,
    email_id character varying(250) NOT NULL,
    status character varying(50) NOT NULL,
    created_by character varying(100),
    created_at date,
    CONSTRAINT user_master_pkey PRIMARY KEY (id)
)