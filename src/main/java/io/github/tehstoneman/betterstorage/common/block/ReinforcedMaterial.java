package io.github.tehstoneman.betterstorage.common.block;

import io.github.tehstoneman.betterstorage.ModInfo;
import io.github.tehstoneman.betterstorage.utils.StackUtils;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ReinforcedMaterial
{
	private final String		name;
	private final String		modID;
	private final Object		ingot;
	private final Object		block;

	public static final String	TAG_NAME	= "Material";

	public ReinforcedMaterial( String name, Object ingot, Object block )
	{
		this( ModInfo.modId, name, ingot, block );
	}

	public ReinforcedMaterial( String modID, String name, Object ingot, Object block )
	{
		this.modID = modID;
		this.name = name;
		this.ingot = ingot;
		this.block = block;
	}

	private ReinforcedMaterial( String name )
	{
		this( ModInfo.modId, name, null, null );
	}

	public ShapedOreRecipe getReinforcedRecipe( Block middle, Block result )
	{
		//if( ingot == null || block == null )
			return null;
		//@formatter:off
		/*return new ShapedOreRecipe( setMaterial( new ItemStack( result ) ),
								"o#o",
								"#C#",
								"oOo",	'C', middle,
										'#', "logWood",
										'o', ingot,
										'O', block );*/
		//@formatter:on
	}

	public ResourceLocation getModelResource( String model, boolean large )
	{
		return new ResourceLocation( modID, "models/" + model + ( large ? "_large/" : "/" ) + name );
	}

	public ResourceLocation getTextureResource( String model, boolean large )
	{
		return new ResourceLocation( modID, "textures/models/" + model + ( large ? "_large/" : "/" ) + name + ".png" );
	}

	public ItemStack setMaterial( ItemStack stack )
	{
		StackUtils.set( stack, name, TAG_NAME );
		return stack;
	}

	public String getUnlocalizedName()
	{
		return "material." + modID + "." + name;
	}
}
