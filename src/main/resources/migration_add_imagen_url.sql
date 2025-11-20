-- Script SQL para agregar la columna imagen_url a la tabla notificacion
-- Ejecutar este script en Supabase si Hibernate no actualiza automáticamente el esquema

ALTER TABLE notificacion 
ADD COLUMN IF NOT EXISTS imagen_url VARCHAR(500);

-- Verificar que la columna se agregó correctamente
SELECT column_name, data_type 
FROM information_schema.columns 
WHERE table_name = 'notificacion' AND column_name = 'imagen_url';

