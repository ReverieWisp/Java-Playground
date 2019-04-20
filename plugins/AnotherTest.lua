function plugin(msg)
	if(string.len(msg) > 5) then
		return nil;
	end

	return msg;
end