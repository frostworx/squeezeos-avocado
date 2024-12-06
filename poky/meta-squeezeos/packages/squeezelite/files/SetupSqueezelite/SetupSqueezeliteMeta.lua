--[[

Setup Squeezelite Meta - configuration support for Squeezelite
player to set alsa params SqueezeOS (jive) Player Instance

(c) 2013-2014, Adrian Smith, triode1@btinternet.com
(c) 2024-2025, Ralph Irving, ralph_irving@hotmail.com

--]]

local oo         = require("loop.simple")
local os         = require("os")
local System     = require("jive.System")
local AppletMeta = require("jive.AppletMeta")
local jiveMain   = jiveMain

local initScript = "/etc/init.d/squeezelite"

module(...)
oo.class(_M, AppletMeta)


function jiveVersion(meta)
	return 1, 1
end


function defaultSettings(meta)
	return { 
	}
end


function registerApplet(meta)

	if not System:hasAudioByDefault() then
	
		-- Start squeezelite
		local success = os.execute(initScript .. " restart")
		if success ~= 0 then
			log:warn("There was a problem starting squeezelite: ", success)
		end

		jiveMain:addItem(
			meta:menuItem('appletSetupSqueezelite', 'settingsAudio', meta:string("APPLET_NAME"),
						  function(applet, ...) applet:deviceMenu(...) end
			)
		)
	end
end
