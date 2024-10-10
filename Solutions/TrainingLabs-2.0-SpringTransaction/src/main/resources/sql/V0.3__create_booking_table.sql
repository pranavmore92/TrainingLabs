CREATE TABLE IF NOT EXISTS public.booking_master
(
    id integer NOT NULL,
    bus_id integer NOT NULL,
    user_id integer NOT NULL,
    payment_id integer NOT NULL,
    booking_date date NOT NULL,
    seat_no integer NOT NULL,
    status character varying(50) NOT NULL,
    created_by character varying(100),
    created_at date,
    CONSTRAINT booking_master_pkey PRIMARY KEY (id)
)