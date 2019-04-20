-- This function takes a string as an argument.
-- It then checks to see if it contains 'silly' - if it does, it replies 
-- with 'Silly word!'. If not, it returns nil, and other plugins can run.
function plugin(msg)
	if string.match(msg, "silly") then
		return "Silly word!";
	else
		return nil;
	end
end